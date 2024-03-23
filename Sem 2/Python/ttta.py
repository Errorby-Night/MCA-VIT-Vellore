# Definition for singly-linked list.
# class ListNode(object):
#     def _init_(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeZeroSumSublists(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        sum = 0
        temp = head
        dict_sum = {}
        while temp is not None:
            sum+=temp.val
            dict_sum[sum] = temp
            temp = temp.next
        sum = 0
        temp = head
        while temp is not None:
            sum+=temp.val
            temp.next = dict_sum[sum].next
            temp = temp.next