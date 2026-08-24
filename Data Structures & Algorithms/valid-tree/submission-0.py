class Solution:
    def dfs(self, graph, n, parent, visit):
        if n in visit:
            return False

        visit.add(n)
        for nei in graph[n]:
            if nei == parent:
                continue
            if not self.dfs(graph, nei, n, visit):
                return False
        
        return True

    def validTree(self, n: int, edges: List[List[int]]) -> bool:
       graph = {}
       for i in range(n):
        graph[i] = []
       for edge in edges:
        graph[edge[0]].append(edge[1])
        graph[edge[1]].append(edge[0])
       
       visit = set()
       if not self.dfs(graph, 0, -1, visit):
            return False
       return len(visit) == n