class Solution:
    def dfs(self, crs, courseMap, visit, cycle, res):
        if crs in cycle:
            return False
        if crs in visit:
            return True

        cycle.add(crs)
        for pre in courseMap[crs]:
            if not self.dfs(pre, courseMap, visit,cycle, res): 
                return False
        
        cycle.remove(crs)
        visit.add(crs)
        res.append(crs)
        return True

    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        courseMap = {}
        visit = set()
        cycle = set()
        for i in range(numCourses):
            courseMap[i] = []
        
        for crs,pre in prerequisites:
            courseMap[crs].append(pre)

        res = []
        for crs in range(numCourses):
            if not self.dfs(crs, courseMap, visit, cycle, res):
                return []
        return res