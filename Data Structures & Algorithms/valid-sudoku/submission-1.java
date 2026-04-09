class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> column = new HashMap<>();
        Map<List<Integer>, Set<Character>> square = new HashMap<>();
        
        int l = board[0].length;
    
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                char val = board[i][j];
                if (val == '.') {
                    continue;
                }

                List<Integer> key = List.of(i / 3, j / 3);

                row.putIfAbsent(i, new HashSet<>());
                column.putIfAbsent(j, new HashSet<>());
                square.putIfAbsent(key, new HashSet<>());

                if (row.get(i).contains(val) ||
                    column.get(j).contains(val) ||
                    square.get(key).contains(val)) {
                    return false;
                }

                row.get(i).add(val);
                column.get(j).add(val);
                square.get(key).add(val);
            }
        }

        return true;
    }
}
