#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        matchmap = dict()
        for i, num in enumerate(nums):
            if num in matchmap:
                return matchmap[num], i
            
            matchmap[target - num] = i

        return -1, -1
        
# @lc code=end

