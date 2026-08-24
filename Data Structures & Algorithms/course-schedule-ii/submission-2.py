class Solution:
    def dfs(self, crs, courseMap, processed, cycle, res):
        if crs in cycle:
            return False
        if crs in processed:
            return True

        cycle.add(crs)
        for pre in courseMap[crs]:
            if not self.dfs(pre, courseMap, processed, cycle, res): 
                return False
        
        cycle.remove(crs)
        processed.add(crs)
        res.append(crs)
        return True

    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        courseMap = {}
        processed = set()
        cycle = set()
        for i in range(numCourses):
            courseMap[i] = []
        
        for crs,pre in prerequisites:
            courseMap[crs].append(pre)

        res = []
        for crs in range(numCourses):
            if not self.dfs(crs, courseMap, processed, cycle, res):
                return []
        return res