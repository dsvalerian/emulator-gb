package com.github.dsvalerian.emu.gb.cpu

import com.github.dsvalerian.emu.common.utils.DataUtils.combine
import com.github.dsvalerian.emu.common.utils.DataUtils.getHigh
import com.github.dsvalerian.emu.common.utils.DataUtils.getLow
import com.github.dsvalerian.emu.common.utils.DataUtils.readBit
import com.github.dsvalerian.emu.common.utils.DataUtils.writeBit

class Registers {
    var a: UByte = 0x0u
    var f: UByte = 0x0u
    var b: UByte = 0x0u
    var c: UByte = 0x0u
    var d: UByte = 0x0u
    var e: UByte = 0x0u
    var h: UByte = 0x0u
    var l: UByte = 0x0u

    var af: UShort
        get() = combine(a, f)
        set(value) {
            a = getHigh(value)
            f = getLow(value)
        }

    var bc: UShort
        get() = combine(b, c)
        set(value) {
            b = getHigh(value)
            c = getLow(value)
        }

    var de: UShort
        get() = combine(d, e)
        set(value) {
            d = getHigh(value)
            e = getLow(value)
        }

    var hl: UShort
        get() = combine(h, l)
        set(value) {
            h = getHigh(value)
            l = getLow(value)
        }

    var sp: UShort = 0x0u
    var pc: UShort = 0x0u

    fun setZeroFlag(value: Boolean) {
        f = writeBit(f, 7, value)
    }

    fun setSubFlag(value: Boolean) {
        f = writeBit(f, 6, value)
    }

    fun setHalfCarryFlag(value: Boolean) {
        f = writeBit(f, 5, value)
    }

    fun setCarryFlag(value: Boolean) {
        f = writeBit(f, 4, value)
    }

    fun getZeroFlag(): Boolean {
        return readBit(f, 7)
    }

    fun getSubFlag(): Boolean {
        return readBit(f, 6)
    }

    fun getHalfCarryFlag(): Boolean {
        return readBit(f, 5)
    }

    fun getCarryFlag(): Boolean {
        return readBit(f, 4)
    }
}