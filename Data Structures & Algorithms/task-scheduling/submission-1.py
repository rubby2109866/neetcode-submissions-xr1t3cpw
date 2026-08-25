class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = {}
        for task in tasks: 
                count[task] = count.get(task,0) + 1

        maxHeap = []
        for cnt in count.values():
            if cnt > 0:
                heapq.heappush(maxHeap, -cnt)
        
        time = 0
        q = deque()
        while maxHeap or q:
            time += 1

            if maxHeap:
                cnt = abs(heapq.heappop(maxHeap)) - 1;
                if cnt > 0:
                    q.append([cnt, time + n])

            if q and q[0][1] == time: 
                heapq.heappush(maxHeap, -q.popleft()[0])


        return time