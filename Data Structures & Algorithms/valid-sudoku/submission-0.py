class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = defaultdict(set)
        column = defaultdict(set)
        square = defaultdict(set)
        
        l = len(board[0])
    
        for i in range(l):
            for j in range(l):
                val = board[i][j]
                if val == ".":
                    continue
                if (val in column[j] or val in row[i] or val in square[(i // 3, j // 3)]):
                    return False

                column[j].add(val)
                row[i].add(val)
                square[(i // 3, j // 3)].add(val)
        
        return True