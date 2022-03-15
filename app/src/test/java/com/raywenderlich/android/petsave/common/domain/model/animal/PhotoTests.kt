package com.raywenderlich.android.petsave.common.domain.model.animal

import junit.framework.Assert.assertEquals
import org.junit.Test

class PhotoTests {
    private val mediumPhoto = "mediumPhoto"
    private val fullPhoto = "fullPhoto"
    private val invalidPhoto = "" // what’s tested in Photo.isValidPhoto()

    @Test
    fun photo_getSmallestAvailablePhoto_hasMediumPhoto() {
        // Given
        val photo = Media.Photo(mediumPhoto, fullPhoto)
        val expectedValue = mediumPhoto

        // When
        val smallestPhoto = photo.getSmallestAvailablePhoto()

        // Then
        assertEquals(smallestPhoto, mediumPhoto)
    }

    @Test
    fun photo_getSmallestAvailablePhoto_noPhotos() {
        // Given
        val photo = Media.Photo("", "")
        val expectedValue = invalidPhoto

        // When
        val smallestPhoto = photo.getSmallestAvailablePhoto()

        // Then
        assertEquals(smallestPhoto, expectedValue)
    }

    @Test
    fun photo_getSmallestAvailablePhoto_hasFullPhoto() {
        // Given
        val photo = Media.Photo("", fullPhoto)
        val expectedValue = fullPhoto

        // When
        val smallestPhoto = photo.getSmallestAvailablePhoto()

        // Then
        assertEquals(smallestPhoto, expectedValue)
    }
}