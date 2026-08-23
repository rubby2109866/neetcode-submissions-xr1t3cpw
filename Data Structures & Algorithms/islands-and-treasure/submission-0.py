class Solution:
    def addNeighbours(self, grid, visited, q, r, c, rows, cols):
        if r < 0 or r >= rows or c < 0 or c >= cols  or (r,c) in visited or grid[r][c] == -1:
            return
        
        visited.add((r,c))
        q.append([r,c])    
    
    
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        rows = len(grid)
        cols = len(grid[0])
        visited = set()
        q = []
        for r in range(rows):
            for c in range(cols):
                    if grid[r][c] == 0:
                        q.append([r,c])
                        visited.add((r,c))

        dist = 0
        while q:
            for i in range(len(q)):
                r, c = q.pop(0)
                grid[r][c] = dist

                self.addNeighbours(grid, visited, q, r + 1, c, rows, cols)
                self.addNeighbours(grid, visited, q, r - 1, c, rows, cols)
                self.addNeighbours(grid, visited, q, r, c + 1, rows, cols)
                self.addNeighbours(grid, visited, q, r, c - 1, rows, cols)
            dist += 1