class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        intervals.sort(key=lambda x: x[0])
        res.append(intervals[0])

        for i in range(1, len(intervals)):
            if res[-1][1] >= intervals[i][0]:
                newInterval = [min(res[-1][0], intervals[i][0]), max(res[-1][1], intervals[i][1])]
                res[-1] = newInterval
            elif res[-1][1] < intervals[i][0]:
                res.append(intervals[i])
        return res

