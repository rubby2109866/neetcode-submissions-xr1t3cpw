# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def height(self, node):
        if not node:
            return [True, 0]

        left = self.height(node.left)
        right = self.height(node.right)

        balanced = (left[0] and right[0] and abs(left[1] - right[1]) <= 1)

        return [balanced, 1 + max(left[1], right[1])]  
    
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        res = self.height(root)
        print(res)
        return res[0]