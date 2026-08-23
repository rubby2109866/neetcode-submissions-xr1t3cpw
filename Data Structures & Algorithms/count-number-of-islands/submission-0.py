class Solution:
    def dfs(self, board, visited, r, c, rows, cols):
        if r < 0 or r >= rows or c < 0 or c >= cols  or (r,c) in visited or board[r][c] == "0":
            return 
        
        visited.add((r,c))

        self.dfs(board, visited, r + 1, c, rows, cols) 
        self.dfs(board, visited, r - 1, c, rows, cols) 
        self.dfs(board, visited, r, c + 1, rows, cols) 
        self.dfs(board, visited, r, c - 1, rows, cols)

        return
    
    
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        visited = set()
        self.res = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and (r,c) not in visited:
                    self.res += 1
                    self.dfs(grid, visited, r, c, rows, cols)
        
        return self.res