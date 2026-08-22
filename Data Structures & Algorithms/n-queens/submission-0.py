class Solution:
    def backtrack(self, n, r, col, posDiag, negDiag, res, board):
        if r == n:
            copy = []
            for row in board:
                copy.append("".join(row))
            res.append(copy)


        for c in range(n):
            if c in col or (r + c) in posDiag or (r - c) in negDiag:
                continue

            col.add(c)
            posDiag.add(r + c)
            negDiag.add(r - c)
            board[r][c] = "Q"
            
            self.backtrack(n, r + 1, col, posDiag, negDiag, res, board)

            col.remove(c)
            posDiag.remove(r + c)
            negDiag.remove(r - c)
            board[r][c] = "."
            
    def solveNQueens(self, n: int) -> List[List[str]]:
       col = set()
       posDiag = set()
       negDiag = set()
       board = []
       res = []
       for i in range(n):
          board.append(["."] * n)

       self.backtrack(n, 0, col, posDiag, negDiag, res, board)
       return res
     
                

       