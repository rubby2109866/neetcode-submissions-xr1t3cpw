# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def dfs(self, node, res):
        if not node:
            return 
        
        self.dfs(node.left, res)
        res.append(node.val)
        self.dfs(node.right, res)
        
        return
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        res = []
        self.dfs(root, res)
        
        return res[k - 1]