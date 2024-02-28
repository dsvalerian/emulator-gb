package com.github.dsvalerian.emu.gb.utils

object DataUtils {
    fun combine(high: UByte, low: UByte): UShort {
        val newHigh: Int = high.toInt() shl 8
        val newLow: Int = low.toInt()

        return (newHigh or newLow).toUShort()
    }

    fun getHigh(value: UShort): UByte {
        val newData: Int = value.toInt() shr 8

        return newData.toUByte()
    }

    fun getLow(value: UShort): UByte {
        return value.toUByte()
    }

    fun setBit(byte: UByte, bitIndex: Int, value: Boolean): UByte {
        val bit: Int = 1 shl bitIndex

        return if (value) (byte.toInt() or bit).toUByte() else (byte.toInt() and bit.inv()).toUByte()
    }
}