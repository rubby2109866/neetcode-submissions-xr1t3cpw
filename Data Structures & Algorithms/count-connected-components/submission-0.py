class Solution:
    def dfs(self, graph, n, visit, processed):
        if n in visit:
            return
        if n in processed:
            return

        visit.add(n)
        for nei in graph[n]:
            self.dfs(graph, nei, visit, processed)
        
        visit.remove(n)
        processed.add(n)
        return 

    def countComponents(self, n: int, edges: List[List[int]]) -> int:

       graph = {}
       for i in range(n):
        graph[i] = []
       for edge in edges:
        graph[edge[0]].append(edge[1])
        graph[edge[1]].append(edge[0])
       print(graph)
       visit = set()
       processed = set()
       res = 0
       for n in range(n):
        if n not in processed:
            self.dfs(graph, n, visit, processed)
            res += 1
       return res
       



