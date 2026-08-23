class Solution:
    def dfs(self, crs, courseMap, visit):
        if crs in visit:
            return False
        if courseMap[crs] == []:
            return True

        visit.add(crs)
        for pre in courseMap[crs]:
            if not self.dfs(pre, courseMap, visit): 
                return False
        
        visit.remove(crs)
        courseMap[crs] = []
        return True


    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courseMap = {}
        visit = set()
        for i in range(numCourses):
            courseMap[i] = []
        
        for crs,pre in prerequisites:
            courseMap[crs].append(pre)

        for crs in range(numCourses):
            if not self.dfs(crs, courseMap, visit):
                return False
        return True