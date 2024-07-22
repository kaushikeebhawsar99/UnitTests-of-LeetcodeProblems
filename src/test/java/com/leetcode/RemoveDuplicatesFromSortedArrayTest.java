package com.leetcode;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesFromSortedArrayTest {

    //An instance of the RemoveDuplicatesFromSortedArray class is created as "solution".
    // This instance is used to call the removeDuplicates method available in RemoveDuplicatesFromSortedArray class.
    RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();


    //firstly, create two annotation
    // beforeAll and AfterAll to run setup and cleanup methods for all the tests
    @BeforeAll
    static void setUp() {
        System.out.println("Unit tests begins!");
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Unit tests completed successfully!");
    }

    //then nesting all the tests related to remove duplicate method using @nested annotation
    @Nested
    @DisplayName("Tests for removeDuplicates method")
    class RemoveDuplicatesTests {

        @Test
        @DisplayName("should_ReturnCorrectCountAndModifiedArray_When_DuplicatesPresent")

        //The method name follows the should_When convention,
            // indicating what the method is testing and under what conditions.
            // In this case, it tests that the method removeDuplicates returns the
            // correct count of unique elements and modifies the array correctly
            // when duplicates are present.

        void should_ReturnCorrectCountAndModifiedArray_When_DuplicatesPresent() {

            //-----------------------------------Example 1------------------------------------
            //GIVEN: This comment indicates the setup phase of the test.
            // The input array nums1 is defined, containing duplicates.
            int[] nums1 = {1, 1, 2};

            //WHEN: The removeDuplicates method is called with the nums1 array.
            // The result is stored in the variable k1. This variable represents
            // the count of unique elements returned by the method.
            int k1 = solution.removeDuplicates(nums1);

            //THEN: assertEquals assertion checks if the returned count k1 is equal to 2.
            // This verifies that the method correctly counted the number of unique elements in the array.
            assertEquals(2, k1);

            //THEN: This assertion checks if the first k1 elements of the modified
            // nums1 array match the expected unique elements {1, 2}.
            // The java.util.Arrays.copyOf(nums1, k1) creates a new array
            // containing the first k1 elements of nums1.
            assertArrayEquals(new int[]{1, 2}, java.util.Arrays.copyOf(nums1, k1));

            //------------------------------------Example 2-------------------------------------
            int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
            int k2 = solution.removeDuplicates(nums2);
            assertEquals(5, k2);
            assertArrayEquals(new int[]{0, 1, 2, 3, 4}, java.util.Arrays.copyOf(nums2, k2));

            //--------------------------------------Example 3-----------------------------------
            int[] nums3 = {1, 2, 3, 4, 5};
            int k3 = solution.removeDuplicates(nums3);
            assertEquals(5, k3);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, java.util.Arrays.copyOf(nums3, k3));

            //--------------------------------------Example 4-----------------------------------
            int[] nums4 = {0,0,1,5,10,10,10};
            int k4 = solution.removeDuplicates(nums4);
            assertEquals(4, k4);
            assertArrayEquals(new int[]{0, 1, 5, 10}, java.util.Arrays.copyOf(nums4, k4));
        }

        @Test
        @DisplayName("should_ReturnZero_When_ArrayIsEmpty")
        void should_ReturnZero_When_ArrayIsEmpty() {
            int[] nums4 = {};
            int k4 = solution.removeDuplicates(nums4);
            assertEquals(0, k4);
        }

        @Test
        @DisplayName("should_ReturnOne_When_ArrayHasOneElement")
        void should_ReturnOne_When_ArrayHasOneElement() {
            int[] nums5 = {1};
            int k5 = solution.removeDuplicates(nums5);
            assertEquals(1, k5);
            assertArrayEquals(new int[]{1}, java.util.Arrays.copyOf(nums5, k5));
        }

        @Test
        @DisplayName("should_ReturnOne_When_AllElementsAreSame")
        void should_ReturnOne_When_AllElementsAreSame() {
            int[] nums6 = {1, 1, 1, 1};
            int k6 = solution.removeDuplicates(nums6);
            assertEquals(1, k6);
            assertArrayEquals(new int[]{1}, java.util.Arrays.copyOf(nums6, k6));
        }

        @Test
        @DisplayName("should_ReturnCorrectCountAndModifiedArray_When_AllElementsAreUnique")
        void should_ReturnCorrectCountAndModifiedArray_When_AllElementsAreUnique() {
            int[] nums7 = {1, 2, 3, 4, 5};
            int k7 = solution.removeDuplicates(nums7);
            assertEquals(5, k7);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, java.util.Arrays.copyOf(nums7, k7));
        }


        //In this testcase, it tests that the removeDuplicates method throws an
        // IllegalArgumentException when the input array is null.
        @Test
        @DisplayName("should_ThrowIllegalArgumentException_When_ArrayIsNull")
        void should_ThrowIllegalArgumentException_When_ArrayIsNull() {
            //Define an Executable lambda expression that calls the removeDuplicates method
            // with a null argument. This lambda will be used to check if the method
            // throws the expected exception.
            Executable executable = () -> solution.removeDuplicates(null);

            //Use the assertThrows method to check that the executable throws an
            // IllegalArgumentException. The thrown exception is captured in the exception variable.
            Exception exception = assertThrows(IllegalArgumentException.class, executable);

            //Verification:
            //expectedMessage is defined with the expected exception message.
            //actualMessage is extracted from the thrown exception.
            //Use assertTrue to check that actualMessage contains expectedMessage.
            String expectedMessage = "Input array cannot be null";
            String actualMessage = exception.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }



        //In this testcase, it tests that the removeDuplicates method returns the correct
        // count of unique elements and modifies the array correctly when the input array is large.
        @Test
        @DisplayName("should_ReturnCorrectCountAndModifiedArray_When_ArrayIsLarge")
        void should_ReturnCorrectCountAndModifiedArray_When_ArrayIsLarge() {
            //GIVEN: The input array nums8 is defined with a size of 30,000 elements.
            // Each element in the array appears 10 times consecutively, so the array
            // contains 3,000 unique elements (from 0 to 2999, each repeated 10 times).
            int[] nums8 = new int[30000];
            for (int i = 0; i < 30000; i++) {
                nums8[i] = i / 10; // Each number appears 10 times
            }

            //WHEN: The removeDuplicates method is called with the nums8 array. The result is
            // stored in the variable k8. This variable represents the count of unique
            // elements returned by the method.
            int k8 = solution.removeDuplicates(nums8);

            //THEN: This assertion checks if the returned count k8 is equal to 3000.
            // This verifies that the method correctly counted the number of
            // unique elements in the large array.
            assertEquals(3000, k8);


            //THEN: This section sets up the expected result for the first 3000
            // elements of the modified array nums8. The expected result is an array
            // of numbers from 0 to 2999. The assertArrayEquals assertion checks
            // if the first k8 elements of the modified nums8 array match the expected
            // unique elements expectedNums8.
            int[] expectedNums8 = new int[3000];
            for (int i = 0; i < 3000; i++) {
                expectedNums8[i] = i;
            }
            assertArrayEquals(expectedNums8, java.util.Arrays.copyOf(nums8, k8));
        }
    }


}
