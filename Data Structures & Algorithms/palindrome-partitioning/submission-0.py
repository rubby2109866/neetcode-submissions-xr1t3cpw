class Solution:

    def isPali(self, s, l, r):
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True
    
    def dfs(self, s, i, res, part):
        if i == len(s):
            res.append(part.copy())
            return
        
        for j in range(i, len(s)):
            if self.isPali(s, i, j):
                part.append(s[i:j+1])
                self.dfs(s, j + 1, res, part)
                part.pop()

        
    def partition(self, s: str) -> List[List[str]]:
        res = []
        self.dfs(s, 0, res, [])

        return res