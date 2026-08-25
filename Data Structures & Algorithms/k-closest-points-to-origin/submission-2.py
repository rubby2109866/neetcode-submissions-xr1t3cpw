class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        maxHeap = []

        for point in points:
            x = point[0]
            y = point[1]
            distance = x * x + y * y
            heapq.heappush(maxHeap, [-distance, x, y])
            if len(maxHeap) > k:
                heapq.heappop(maxHeap)
        

        result = []
        while maxHeap: 
            temp = heapq.heappop(maxHeap)
            result.append([temp[1], temp[2]])

        return result;
        