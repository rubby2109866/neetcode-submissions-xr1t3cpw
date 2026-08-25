class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxHeap = []
        for stone in stones:
            heapq.heappush(maxHeap, -stone)

        while len(maxHeap) > 1:
            x = heapq.heappop(maxHeap)
            y = heapq.heappop(maxHeap)
            if x == y:
                continue
            else:
                heapq.heappush(maxHeap, -abs(x-y))
    
        if len(maxHeap) == 1: 
            return -maxHeap[0]
        
        return 0;