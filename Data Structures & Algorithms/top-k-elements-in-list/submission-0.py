class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # heapq approach O(nlogn)
        h = {}
        for i,n in enumerate(nums):
            if n in h:
                h[n] += 1
            else: 
                h[n] = 1

        heap = []
        for num in h.keys():
            heapq.heappush(heap, (h[num], num))
            if len(heap) > k:
                heapq.heappop(heap)

        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res

        
        
        # Map approach with sorting O(nlogn)
        # h = {}
        # for i,n in enumerate(nums):
        #     if n in h:
        #         h[n] += 1
        #     else: 
        #         h[n] = 1
        # arr = []
        # for num, cnt in h.items():
        #     arr.append([cnt, num])
        # arr.sort()
        # res = []
        # while len(res) < k:
        #     res.append(arr.pop()[1])
        # return res