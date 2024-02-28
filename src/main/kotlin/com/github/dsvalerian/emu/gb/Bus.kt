package com.github.dsvalerian.emu.gb

class Bus {
    private val ram: UByteArray = UByteArray(0x10000)

    fun write(address: UShort, data: UByte) {
        ram[address.toInt()] = data
    }

    fun read(address: UShort): UByte {
        return ram[address.toInt()]
    }
}