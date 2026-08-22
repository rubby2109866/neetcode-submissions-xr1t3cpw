class Solution:
    def dfs(self, board, word, visited, i, r, c, rows, cols):
        if i == len(word):
            return True
        
        if r < 0 or r >= rows or c < 0 or c >= cols or word[i] != board[r][c] or (r,c) in visited:
            return False
        
        visited.add((r,c))

        res = self.dfs(board, word, visited, i + 1, r + 1, c, rows, cols) or self.dfs(board, word, visited, i + 1, r - 1, c, rows, cols) or self.dfs(board, word, visited, i + 1, r, c + 1, rows, cols) or self.dfs(board, word, visited, i + 1, r, c - 1, rows, cols)

        visited.remove((r,c))

        return res

    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        visited = set()
        for r in range(rows):
            for c in range(cols):
                if self.dfs(board, word, visited, 0, r, c, rows, cols):
                    return True
        
        return False