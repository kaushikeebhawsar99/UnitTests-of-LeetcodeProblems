package com.leetcode;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {
    @BeforeAll
    static void setUp() {
        System.out.println("Unit tests begins!");
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Unit tests completed successfully!");
    }

    @Nested
    @DisplayName("Tests for removeDuplicates method")
    class RemoveDuplicatesTests {

        @Test
        @DisplayName("should_ReturnCorrectCountAndModifiedArray_When_DuplicatesPresent")
        void should_ReturnCorrectCountAndModifiedArray_When_DuplicatesPresent() {
            RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

            int[] nums1 = {1, 1, 2};
            int k1 = solution.removeDuplicates(nums1);
            assertEquals(2, k1);
            assertArrayEquals(new int[]{1, 2}, java.util.Arrays.copyOf(nums1, k1));

            int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
            int k2 = solution.removeDuplicates(nums2);
            assertEquals(5, k2);
            assertArrayEquals(new int[]{0, 1, 2, 3, 4}, java.util.Arrays.copyOf(nums2, k2));

            int[] nums3 = {1, 2, 3, 4, 5};
            int k3 = solution.removeDuplicates(nums3);
            assertEquals(5, k3);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, java.util.Arrays.copyOf(nums3, k3));

            int[] nums4 = {0,0,1,5,10,10,10};
            int k4 = solution.removeDuplicates(nums4);
            assertEquals(4, k4);
            assertArrayEquals(new int[]{0, 1, 5, 10}, java.util.Arrays.copyOf(nums4, k4));
        }

        @Test
        @DisplayName("should_ReturnZero_When_ArrayIsEmpty")
        void should_ReturnZero_When_ArrayIsEmpty() {
            RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

            int[] nums4 = {};
            int k4 = solution.removeDuplicates(nums4);
            assertEquals(0, k4);
        }

        @Test
        @DisplayName("should_ReturnOne_When_ArrayHasOneElement")
        void should_ReturnOne_When_ArrayHasOneElement() {
            RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

            int[] nums5 = {1};
            int k5 = solution.removeDuplicates(nums5);
            assertEquals(1, k5);
            assertArrayEquals(new int[]{1}, java.util.Arrays.copyOf(nums5, k5));
        }

        @Test
        @DisplayName("should_ReturnOne_When_AllElementsAreSame")
        void should_ReturnOne_When_AllElementsAreSame() {
            RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

            int[] nums6 = {1, 1, 1, 1};
            int k6 = solution.removeDuplicates(nums6);
            assertEquals(1, k6);
            assertArrayEquals(new int[]{1}, java.util.Arrays.copyOf(nums6, k6));
        }

        @Test
        @DisplayName("should_ReturnCorrectCountAndModifiedArray_When_AllElementsAreUnique")
        void should_ReturnCorrectCountAndModifiedArray_When_AllElementsAreUnique() {
            RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

            int[] nums7 = {1, 2, 3, 4, 5};
            int k7 = solution.removeDuplicates(nums7);
            assertEquals(5, k7);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, java.util.Arrays.copyOf(nums7, k7));
        }

        @Test
        @DisplayName("should_ThrowIllegalArgumentException_When_ArrayIsNull")
        void should_ThrowIllegalArgumentException_When_ArrayIsNull() {
            RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

            Executable executable = () -> solution.removeDuplicates(null);
            Exception exception = assertThrows(IllegalArgumentException.class, executable);
            String expectedMessage = "Input array cannot be null";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        @DisplayName("should_ReturnCorrectCountAndModifiedArray_When_ArrayIsLarge")
        void should_ReturnCorrectCountAndModifiedArray_When_ArrayIsLarge() {
            RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

            int[] nums8 = new int[30000];
            for (int i = 0; i < 30000; i++) {
                nums8[i] = i / 10; // Each number appears 10 times
            }
            int k8 = solution.removeDuplicates(nums8);
            assertEquals(3000, k8);

            int[] expectedNums8 = new int[3000];
            for (int i = 0; i < 3000; i++) {
                expectedNums8[i] = i;
            }
            assertArrayEquals(expectedNums8, java.util.Arrays.copyOf(nums8, k8));
        }
    }


}