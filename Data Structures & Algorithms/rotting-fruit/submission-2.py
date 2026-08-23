class Solution:
    def rotFruits(self, grid, visited, q, r, c, rows, cols):
        if r < 0 or r >= rows or c < 0 or c >= cols  or (r,c) in visited or grid[r][c] == 0:
            return
        if grid[r][c] == 1:
            visited.add((r,c))
            grid[r][c] = 2
            q.append([r,c]) 


    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        visit = set()
        allRotten = True
        q = []
        fresh = 0
        for r in range(rows):
            for c in range(cols):
                    if grid[r][c] == 2:
                        q.append([r,c])
                        visit.add((r,c))
                    elif grid[r][c] == 1:
                        fresh += 1
        if fresh == 0:
            return 0

        if not q:
            return -1

        minutes = 0
        while q:
            for i in range(len(q)):
                r, c = q.pop(0)
                self.rotFruits(grid, visit, q, r + 1, c, rows, cols)
                self.rotFruits(grid, visit, q, r - 1, c, rows, cols)
                self.rotFruits(grid, visit, q, r, c + 1, rows, cols)
                self.rotFruits(grid, visit, q, r, c - 1, rows, cols)
            minutes += 1

        for r in range(rows):
            for c in range(cols):
                    if grid[r][c] == 1:
                        allRotten = False
                        
        return minutes - 1 if allRotten else -1