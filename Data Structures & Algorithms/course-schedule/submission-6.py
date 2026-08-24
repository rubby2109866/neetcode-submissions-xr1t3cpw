class Solution:
    def dfs(self, crs, courseMap, cycle, processed):
        if crs in cycle:
            return False
        
        if crs in processed:
            return True

        cycle.add(crs)
        for pre in courseMap[crs]:
            if not self.dfs(pre, courseMap, cycle, processed): 
                return False
        
        cycle.remove(crs)
        processed.add(crs)
        return True

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseMap = {}
        cycle = set()
        processed = set()
        for i in range(numCourses):
            courseMap[i] = []
        
        for crs,pre in prerequisites:
            courseMap[crs].append(pre)

        for crs in range(numCourses):
            if not self.dfs(crs, courseMap, cycle, processed):
                return False
        return True