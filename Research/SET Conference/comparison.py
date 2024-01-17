import torch
import torch.nn as nn
import torch.optim as optim
from torchvision import models, transforms
from PIL import Image
import matplotlib.pyplot as plt

# Define a function to load and preprocess an image
def load_image(image_path, size=None, scale=None):
    image = Image.open(image_path)
    if size is not None:
        image = image.resize(size)
    if scale is not None:
        image = image.resize((int(image.width * scale), int(image.height * scale)))
    transform = transforms.Compose([transforms.ToTensor()])
    image = transform(image)
    image = image.unsqueeze(0)  # Add a batch dimension
    return image

# Define a function to display an image
def imshow(tensor, title=None):
    image = tensor.clone().cpu()
    image = image.squeeze(0)
    image = transforms.ToPILImage()(image)
    if title is not None:
        plt.title(title)
    plt.imshow(image)
    plt.show()

# Define a function to perform instance normalization
class InstanceNormalization(nn.Module):
    def __init__(self, eps=1e-5):
        super(InstanceNormalization, self).__init__()
        self.eps = eps

    def forward(self, x):
        mean = x.mean(2, keepdim=True).mean(3, keepdim=True)
        std = x.std(2, keepdim=True).std(3, keepdim=True)
        return (x - mean) / (std + self.eps)

# Define a function to get the VGG19 model with instance normalization
def get_vgg_instance_norm_model():
    vgg = models.vgg19(pretrained=True)
    features = vgg.features
    model = nn.Sequential()
    i = 1
    for layer in features:
        if isinstance(layer, nn.Conv2d):
            name = "conv_" + str(i)
            model.add_module(name, layer)
            if name in {'conv_1', 'conv_6', 'conv_11', 'conv_20', 'conv_29'}:
                model.add_module("in_" + str(i), InstanceNormalization())
            i += 1
        if isinstance(layer, nn.ReLU):
            name = "relu_" + str(i)
            layer = nn.ReLU(inplace=False)
            model.add_module(name, layer)
    return model

# Define a function to extract content and style features
def get_features(image, model):
    layers = {
        '0': 'conv_1',
        '5': 'conv_6',
        '10': 'conv_11',
        '19': 'conv_20',
        '28': 'conv_29'
    }
    features = {}
    x = image
    for name, layer in model._modules.items():
        x = layer(x)
        if name in layers:
            features[layers[name]] = x
    return features

# Define a function to compute the Gram matrix for a tensor
def gram_matrix(tensor):
    batch, channels, height, width = tensor.size()
    tensor = tensor.view(channels, height * width)
    gram = torch.mm(tensor, tensor.t())
    return gram

# Define a function for the style loss
def style_loss(target_features, style_features):
    loss = 0
    for target_feature, style_feature in zip(target_features, style_features):
        _, channels, height, width = target_feature.size()
        target_gram = gram_matrix(target_feature)
        style_gram = gram_matrix(style_feature)
        layer_loss = nn.functional.mse_loss(target_gram, style_gram)
        loss += layer_loss / (channels * height * width)
    return loss

# Define a function for the content loss
def content_loss(target_features, content_features):
    loss = 0
    for target_feature, content_feature in zip(target_features, content_features):
        loss += nn.functional.mse_loss(target_feature, content_feature)
    return loss

# Define a function to transfer the style from style_image to content_image
def style_transfer(content_image_path, style_image_path, output_image_path, num_steps=300, style_weight=1000000, content_weight=1):
    content_image = load_image(content_image_path)
    style_image = load_image(style_image_path)
    
    vgg = get_vgg_instance_norm_model()
    
    content_target = get_features(content_image, vgg)
    style_target = get_features(style_image, vgg)
    
    generated = content_image.clone().requires_grad_(True)
    
    optimizer = optim.Adam([generated], lr=0.01)
    
    for step in range(num_steps):
        generated_features = get_features(generated, vgg)
        
        content_loss_val = content_loss(generated_features, content_target)
        style_loss_val = style_loss(generated_features, style_target)
        
        total_loss = content_weight * content_loss_val + style_weight * style_loss_val
        
        optimizer.zero_grad()
        total_loss.backward()
        optimizer.step()
        
        if step % 50 == 0:
            print("Step [{}/{}]: Content Loss: {:.4f} Style Loss: {:.4f}".format(step, num_steps, content_loss_val.item(), style_loss_val.item()))
    
    # Save the generated image
    generated = generated.squeeze(0)
    generated = transforms.ToPILImage()(generated)
    generated.save(output_image_path)

# Example usage
content_image_path = 'D:/Program/College/MCA-VIT-Vellore/Research/SET Conference/brown-Guernsey-cow (1).jpg'
style_image_path = 'D:/Program/College/MCA-VIT-Vellore/Research/SET Conference/style.jpg'
output_image_path = 'output.jpg'
style_transfer(content_image_path, style_image_path, output_image_path)
imshow(load_image(output_image_path), title='Output Image')