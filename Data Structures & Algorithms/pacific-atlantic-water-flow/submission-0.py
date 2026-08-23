class Solution:
    def dfs(self, heights, visit, r, c, rows, cols, prevHeight):
        if r < 0 or r >= rows or c < 0 or c >= cols  or (r,c) in visit or heights[r][c] < prevHeight:
            return
        
        visit.add((r,c))

        self.dfs(heights, visit, r + 1, c, rows, cols, heights[r][c])
        self.dfs(heights, visit, r - 1, c, rows, cols, heights[r][c]) 
        self.dfs(heights, visit, r, c + 1, rows, cols, heights[r][c]) 
        self.dfs(heights, visit, r, c - 1, rows, cols, heights[r][c])

    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows = len(heights)
        cols = len(heights[0])
        atl = set()
        pac = set()

        for c in range(cols):
            self.dfs(heights, pac, 0, c, rows, cols, heights[0][c])
            self.dfs(heights, atl, rows - 1, c, rows, cols, heights[rows - 1][c])
        for r in range(rows):
            self.dfs(heights, pac, r, 0, rows, cols, heights[r][0])
            self.dfs(heights, atl, r, cols - 1, rows, cols, heights[r][cols - 1])

        res = []
        for r in range(rows):
            for c in range(cols):
                if (r,c) in atl and (r,c) in pac:
                    res.append([r,c])
        return res