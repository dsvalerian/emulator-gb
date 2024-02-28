package com.github.dsvalerian.emu.gb.cpu

import com.github.dsvalerian.emu.gb.utils.DataUtils.combine
import com.github.dsvalerian.emu.gb.utils.DataUtils.getHigh
import com.github.dsvalerian.emu.gb.utils.DataUtils.getLow
import com.github.dsvalerian.emu.gb.utils.DataUtils.setBit

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
        f = setBit(f, 7, value)
    }

    fun setSubFlag(value: Boolean) {
        f = setBit(f, 6, value)
    }

    fun setHalfCarryFlag(value: Boolean) {
        f = setBit(f, 5, value)
    }

    fun setCarryFlag(value: Boolean) {
        f = setBit(f, 4, value)
    }
}