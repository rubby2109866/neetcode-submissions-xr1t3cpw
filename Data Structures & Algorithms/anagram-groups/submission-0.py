class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        def createAnagramList(s):
            l = [0] * 26
            for val in s:
                index = ord(val) - ord('a')
                l[index] += 1
            return l
        
        result = []
        anagramMap = {}
        for string in strs:
            l = createAnagramList(string)
            t = tuple(l)
            if t in anagramMap:
                anagramMap[t].append(string)
            else:
                anagramMap[t] = [string]
        for value in anagramMap.values():
            result.append(value)
        return result