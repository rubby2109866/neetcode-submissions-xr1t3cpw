class Solution:
    def dfs(self, board, visit, r, c, rows, cols):
        if r < 0 or r >= rows or c < 0 or c >= cols  or (r,c) in visit or board[r][c] == "X":
            return
        
        visit.add((r,c))

        self.dfs(board, visit, r + 1, c, rows, cols)
        self.dfs(board, visit, r - 1, c, rows, cols) 
        self.dfs(board, visit, r, c + 1, rows, cols) 
        self.dfs(board, visit, r, c - 1, rows, cols)

    def solve(self, board: List[List[str]]) -> None:
        rows = len(board)
        cols = len(board[0])
        visit = set()

        for r in range(rows):
            for c in range(cols):
                if (c == 0 or r == 0 or c == cols - 1 or r == rows - 1):
                    if board[r][c] == "O":
                        self.dfs(board, visit, r, c, rows, cols)

        
        for r in range(rows):
            for c in range(cols):
                if (r,c) not in visit and board[r][c] == "O":
                    board[r][c] = "X"
    