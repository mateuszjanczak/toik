package com.mateuszjanczak;

interface Cipher {

    /** deszyfrowanie wiadomosci*/
    String decode(final String message);

    /** szyfrowanie wiadomosci */
    String encode(final String message);
}