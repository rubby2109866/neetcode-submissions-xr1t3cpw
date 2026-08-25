class Solution:
    def calculatePali(self,s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            if (r - l + 1) > self.resLen:
                self.resIdx = l
                self.resLen = r - l + 1
            l -= 1
            r += 1

    def longestPalindrome(self, s: str) -> str:
        self.resIdx = 0
        self.resLen = 0

        for i in range(len(s)):
            # odd length
            self.calculatePali(s, i, i)
            # even length
            self.calculatePali(s, i, i + 1)

        return s[self.resIdx : self.resIdx + self.resLen]