#! /usr/bin/env python3
class DisjointSet:
	
	class Element:
		def __init__(self, key):
			self.key = key
			self.parent = self
			self.rank = 0
		
		def __eq__(self, other):
			return self.key ==  other.key
		def __ne__(self, other):
			return self.key != other.key
 
	def __init__(self):
		self.tree = {}
	
	def make_set(self, key):
		# Create and add a new element to the tree
		e = self.Element(key)
		if not key in self.tree.keys():
			self.tree[key] = e

			
	def find(self, key):
		if key in self.tree.keys():
			element = self.tree[key]
			# root is element with itself as parent
			# if not root continue
			if element.parent != element:
				element.parent  = self.find(element.parent.key)
			return element.parent

	
	def union(self, element_a, element_b):
		root_a = self.find(element_a.key)
		root_b = self.find(element_b.key)
		# if not in the same subtree (set)
		if root_a != root_b:
			#merge the sets
			if root_a.rank < root_b.rank:
				root_a.parent = root_b
			elif root_a.rank > root_b.rank:
				root_b.parent = root_a
			else:
				# same rank, set and increment arbitrary root as parent
				root_b.parent = root_a
				root_a.rank+=1
