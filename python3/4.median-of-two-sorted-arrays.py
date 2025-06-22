#
# @lc app=leetcode id=4 lang=python3
#
# [4] Median of Two Sorted Arrays
#

# @lc code=start
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        # Since one of the arrays can be significantly longer than
        # the other, we always perform binary search on the shorter
        # array to ensure that the time complexity remains
        # O(log(min(m, n))).
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        len1, len2 = len(nums1), len(nums2)
        l, r = 0, len1

        while l <= r:
            mid1 = (l + r) // 2
            mid2 = (len1 + len2 + 1) // 2 - mid1

            max_left1 = nums1[mid1 - 1] if mid1 > 0 else float('-inf')
            min_right1 = nums1[mid1] if mid1 < len1 else float('inf')
            max_left2 = nums2[mid2 - 1] if mid2 > 0 else float('-inf')
            min_right2 = nums2[mid2] if mid2 < len2 else float('inf')

            if max_left1 <= min_right2 and max_left2 <= min_right1:
                if (len1 + len2) % 2 == 0:
                    return (max(max_left1, max_left2) + min(min_right1, min_right2)) / 2
                else:
                    return max(max_left1, max_left2)
            elif max_left1 > min_right2:
                r = mid1 - 1
            else:
                l = mid1 + 1

            
# @lc code=end

