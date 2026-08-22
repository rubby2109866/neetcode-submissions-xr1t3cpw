class Solution:
    def dfs(self, n, stack, res, openN, closeN):
        if openN == closeN == n:
            res.append("".join(stack))
            return
        
        if openN < n:
            stack.append("(")
            self.dfs(n, stack, res, openN + 1, closeN)
            stack.pop()
        
        if closeN < openN:
            stack.append(")")
            self.dfs(n, stack, res, openN, closeN + 1)
            stack.pop()


         
    def generateParenthesis(self, n: int) -> List[str]:
        stack = []
        res = []
        self.dfs(n, stack, res , 0, 0)
        return res