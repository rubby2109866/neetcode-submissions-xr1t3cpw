# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def dfs(self, node, prevMax):
        if not node:
            return 
        
        if node.val >= prevMax:
            self.res += 1
        
        if node.left:
            self.dfs(node.left, max(node.left.val, prevMax))
        if node.right:
            self.dfs(node.right, max(node.right.val, prevMax))
        return


    def goodNodes(self, root: TreeNode) -> int:
        self.res = 0
        self.dfs(root, root.val)
        return self.res
        
