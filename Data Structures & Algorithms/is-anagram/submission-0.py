class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        def createAnagramList(s):
            l = [0] * 26
            for val in s:
                index = ord(val) - ord('a')
                l[index] += 1
            return l
        def reduceAnagram(li, t):
            for val in t:
                index = ord(val) - ord('a')
                li[index] -= 1
            return li
        
        
        l = createAnagramList(s)
        res = reduceAnagram(l, t)
        for r in res:
            if r != 0:
                return False
        return True