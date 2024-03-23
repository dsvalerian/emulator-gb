package com.github.dsvalerian.emu.gb.cpu

import com.github.dsvalerian.emu.common.utils.DataUtils

class InstructionPool(private val cpu: Cpu) {
    val lookup: Array<Instruction> = arrayOf(
        Instruction({ nop() }, 4),                      // 0x00
        Instruction({ ldToBC(readImmediate16()) }, 12), // 0x01
        Instruction(::xxx, 0),  // 0x02 todo
        Instruction(::xxx, 0),  // 0x03 todo
        Instruction(::xxx, 0),  // 0x04 todo
        Instruction(::xxx, 0),  // 0x05 todo
        Instruction(::xxx, 0),  // 0x06 todo
        Instruction(::xxx, 0),  // 0x07 todo
        Instruction(::xxx, 0),  // 0x08 todo
        Instruction(::xxx, 0),  // 0x09 todo
        Instruction(::xxx, 0),  // 0x0A todo
        Instruction(::xxx, 0),  // 0x0B todo
        Instruction(::xxx, 0),  // 0x0C todo
        Instruction(::xxx, 0),  // 0x0D todo
        Instruction(::xxx, 0),  // 0x0E todo
        Instruction(::xxx, 0),  // 0x0F todo

        Instruction(::xxx, 0),  // 0x10 todo
        Instruction({ ldToDE(readImmediate16()) }, 12), // 0x11
        Instruction(::xxx, 0),  // 0x12 todo
        Instruction(::xxx, 0),  // 0x13 todo
        Instruction(::xxx, 0),  // 0x14 todo
        Instruction(::xxx, 0),  // 0x15 todo
        Instruction(::xxx, 0),  // 0x16 todo
        Instruction(::xxx, 0),  // 0x17 todo
        Instruction(::xxx, 0),  // 0x18 todo
        Instruction(::xxx, 0),  // 0x19 todo
        Instruction(::xxx, 0),  // 0x1A todo
        Instruction(::xxx, 0),  // 0x1B todo
        Instruction(::xxx, 0),  // 0x1C todo
        Instruction(::xxx, 0),  // 0x1D todo
        Instruction(::xxx, 0),  // 0x1E todo
        Instruction(::xxx, 0),  // 0x1F todo

        Instruction(::xxx, 0),  // 0x20 todo
        Instruction({ ldToHL(readImmediate16()) }, 12), // 0x21
        Instruction(::xxx, 0),  // 0x22 todo
        Instruction(::xxx, 0),  // 0x23 todo
        Instruction(::xxx, 0),  // 0x24 todo
        Instruction(::xxx, 0),  // 0x25 todo
        Instruction(::xxx, 0),  // 0x26 todo
        Instruction(::xxx, 0),  // 0x27 todo
        Instruction(::xxx, 0),  // 0x28 todo
        Instruction(::xxx, 0),  // 0x29 todo
        Instruction(::xxx, 0),  // 0x2A todo
        Instruction(::xxx, 0),  // 0x2B todo
        Instruction(::xxx, 0),  // 0x2C todo
        Instruction(::xxx, 0),  // 0x2D todo
        Instruction(::xxx, 0),  // 0x2E todo
        Instruction(::xxx, 0),  // 0x2F todo

        Instruction(::xxx, 0),  // 0x30 todo
        Instruction({ ldToSP(readImmediate16()) }, 12), // 0x31
        Instruction(::xxx, 0),  // 0x32 todo
        Instruction(::xxx, 0),  // 0x33 todo
        Instruction(::xxx, 0),  // 0x34 todo
        Instruction(::xxx, 0),  // 0x35 todo
        Instruction(::xxx, 0),  // 0x36 todo
        Instruction(::xxx, 0),  // 0x37 todo
        Instruction(::xxx, 0),  // 0x38 todo
        Instruction(::xxx, 0),  // 0x39 todo
        Instruction(::xxx, 0),  // 0x3A todo
        Instruction(::xxx, 0),  // 0x3B todo
        Instruction(::xxx, 0),  // 0x3C todo
        Instruction(::xxx, 0),  // 0x3D todo
        Instruction(::xxx, 0),  // 0x3E todo
        Instruction(::xxx, 0),  // 0x3F todo

        Instruction({ ldToB(cpu.registers.b) }, 4),             // 0x40
        Instruction({ ldToB(cpu.registers.c) }, 4),             // 0x41
        Instruction({ ldToB(cpu.registers.d) }, 4),             // 0x42
        Instruction({ ldToB(cpu.registers.e) }, 4),             // 0x43
        Instruction({ ldToB(cpu.registers.h) }, 4),             // 0x44
        Instruction({ ldToB(cpu.registers.l) }, 4),             // 0x45
        Instruction({ ldToB(cpu.read(cpu.registers.hl)) }, 8),  // 0x46
        Instruction({ ldToB(cpu.registers.b) }, 4),             // 0x47
        Instruction({ ldToC(cpu.registers.b) }, 4),             // 0x48
        Instruction({ ldToC(cpu.registers.c) }, 4),             // 0x49
        Instruction({ ldToC(cpu.registers.d) }, 4),             // 0x4A
        Instruction({ ldToC(cpu.registers.e) }, 4),             // 0x4B
        Instruction({ ldToC(cpu.registers.h) }, 4),             // 0x4C
        Instruction({ ldToC(cpu.registers.l) }, 4),             // 0x4D
        Instruction({ ldToC(cpu.read(cpu.registers.hl)) }, 8),  // 0x4E
        Instruction({ ldToC(cpu.registers.b) }, 4),             // 0x4F

        Instruction({ ldToD(cpu.registers.b) }, 4),             // 0x50
        Instruction({ ldToD(cpu.registers.c) }, 4),             // 0x51
        Instruction({ ldToD(cpu.registers.d) }, 4),             // 0x52
        Instruction({ ldToD(cpu.registers.e) }, 4),             // 0x53
        Instruction({ ldToD(cpu.registers.h) }, 4),             // 0x54
        Instruction({ ldToD(cpu.registers.l) }, 4),             // 0x55
        Instruction({ ldToD(cpu.read(cpu.registers.hl)) }, 8),  // 0x56
        Instruction({ ldToD(cpu.registers.b) }, 4),             // 0x57
        Instruction({ ldToE(cpu.registers.b) }, 4),             // 0x58
        Instruction({ ldToE(cpu.registers.c) }, 4),             // 0x59
        Instruction({ ldToE(cpu.registers.d) }, 4),             // 0x5A
        Instruction({ ldToE(cpu.registers.e) }, 4),             // 0x5B
        Instruction({ ldToE(cpu.registers.h) }, 4),             // 0x5C
        Instruction({ ldToE(cpu.registers.l) }, 4),             // 0x5D
        Instruction({ ldToE(cpu.read(cpu.registers.hl)) }, 8),  // 0x5E
        Instruction({ ldToE(cpu.registers.b) }, 4),             // 0x5F

        Instruction({ ldToH(cpu.registers.b) }, 4),             // 0x60
        Instruction({ ldToH(cpu.registers.c) }, 4),             // 0x61
        Instruction({ ldToH(cpu.registers.d) }, 4),             // 0x62
        Instruction({ ldToH(cpu.registers.e) }, 4),             // 0x63
        Instruction({ ldToH(cpu.registers.h) }, 4),             // 0x64
        Instruction({ ldToH(cpu.registers.l) }, 4),             // 0x65
        Instruction({ ldToH(cpu.read(cpu.registers.hl)) }, 8),  // 0x66
        Instruction({ ldToH(cpu.registers.b) }, 4),             // 0x67
        Instruction({ ldToL(cpu.registers.b) }, 4),             // 0x68
        Instruction({ ldToL(cpu.registers.c) }, 4),             // 0x69
        Instruction({ ldToL(cpu.registers.d) }, 4),             // 0x6A
        Instruction({ ldToL(cpu.registers.e) }, 4),             // 0x6B
        Instruction({ ldToL(cpu.registers.h) }, 4),             // 0x6C
        Instruction({ ldToL(cpu.registers.l) }, 4),             // 0x6D
        Instruction({ ldToL(cpu.read(cpu.registers.hl)) }, 8),  // 0x6E
        Instruction({ ldToL(cpu.registers.b) }, 4),             // 0x6F

        Instruction({ ldToAddr(cpu.registers.hl, cpu.registers.b) }, 4),    // 0x70
        Instruction({ ldToAddr(cpu.registers.hl, cpu.registers.c) }, 4),    // 0x71
        Instruction({ ldToAddr(cpu.registers.hl, cpu.registers.d) }, 4),    // 0x72
        Instruction({ ldToAddr(cpu.registers.hl, cpu.registers.e) }, 4),    // 0x73
        Instruction({ ldToAddr(cpu.registers.hl, cpu.registers.h) }, 4),    // 0x74
        Instruction({ ldToAddr(cpu.registers.hl, cpu.registers.l) }, 4),    // 0x75
        Instruction(::xxx, 0),                                              // 0x76 todo
        Instruction({ ldToAddr(cpu.registers.hl, cpu.registers.b) }, 4),    // 0x77
        Instruction({ ldToA(cpu.registers.b) }, 4),                         // 0x78
        Instruction({ ldToA(cpu.registers.c) }, 4),                         // 0x79
        Instruction({ ldToA(cpu.registers.d) }, 4),                         // 0x7A
        Instruction({ ldToA(cpu.registers.e) }, 4),                         // 0x7B
        Instruction({ ldToA(cpu.registers.h) }, 4),                         // 0x7C
        Instruction({ ldToA(cpu.registers.l) }, 4),                         // 0x7D
        Instruction({ ldToA(cpu.read(cpu.registers.hl)) }, 8),              // 0x7E
        Instruction({ ldToA(cpu.registers.a) }, 4),                         // 0x7F

        Instruction({ addToA(cpu.registers.b) }, 4),            // 0x80
        Instruction({ addToA(cpu.registers.c) }, 4),            // 0x81
        Instruction({ addToA(cpu.registers.d) }, 4),            // 0x82
        Instruction({ addToA(cpu.registers.e) }, 4),            // 0x83
        Instruction({ addToA(cpu.registers.h) }, 4),            // 0x84
        Instruction({ addToA(cpu.registers.l) }, 4),            // 0x85
        Instruction({ addToA(cpu.read(cpu.registers.hl)) }, 8), // 0x86
        Instruction({ addToA(cpu.registers.a) }, 4),            // 0x87
        Instruction({ adcToA(cpu.registers.b) }, 4),            // 0x88
        Instruction({ adcToA(cpu.registers.c) }, 4),            // 0x89
        Instruction({ adcToA(cpu.registers.d) }, 4),            // 0x8A
        Instruction({ adcToA(cpu.registers.e) }, 4),            // 0x8B
        Instruction({ adcToA(cpu.registers.h) }, 4),            // 0x8C
        Instruction({ adcToA(cpu.registers.l) }, 4),            // 0x8D
        Instruction({ adcToA(cpu.read(cpu.registers.hl)) }, 4), // 0x8E
        Instruction({ adcToA(cpu.registers.a) }, 4),            // 0x8F

        Instruction(::xxx, 0), // 0x90 todo
        Instruction(::xxx, 0), // 0x91 todo
        Instruction(::xxx, 0), // 0x92 todo
        Instruction(::xxx, 0), // 0x93 todo
        Instruction(::xxx, 0), // 0x94 todo
        Instruction(::xxx, 0), // 0x95 todo
        Instruction(::xxx, 0), // 0x96 todo
        Instruction(::xxx, 0), // 0x97 todo
        Instruction(::xxx, 0), // 0x98 todo
        Instruction(::xxx, 0), // 0x99 todo
        Instruction(::xxx, 0), // 0x9A todo
        Instruction(::xxx, 0), // 0x9B todo
        Instruction(::xxx, 0), // 0x9C todo
        Instruction(::xxx, 0), // 0x9D todo
        Instruction(::xxx, 0), // 0x9E todo
        Instruction(::xxx, 0), // 0x9F todo

        Instruction({ andToA(cpu.registers.b) }, 4),            // 0xA0
        Instruction({ andToA(cpu.registers.c) }, 4),            // 0xA1
        Instruction({ andToA(cpu.registers.d) }, 4),            // 0xA2
        Instruction({ andToA(cpu.registers.e) }, 4),            // 0xA3
        Instruction({ andToA(cpu.registers.h) }, 4),            // 0xA4
        Instruction({ andToA(cpu.registers.l) }, 4),            // 0xA5
        Instruction({ andToA(cpu.read(cpu.registers.hl)) }, 8), // 0xA6
        Instruction({ andToA(cpu.registers.a) }, 4),            // 0xA7
        Instruction({ xorToA(cpu.registers.b) }, 4),            // 0xA8
        Instruction({ xorToA(cpu.registers.c) }, 4),            // 0xA9
        Instruction({ xorToA(cpu.registers.d) }, 4),            // 0xAA
        Instruction({ xorToA(cpu.registers.e) }, 4),            // 0xAB
        Instruction({ xorToA(cpu.registers.h) }, 4),            // 0xAC
        Instruction({ xorToA(cpu.registers.l) }, 4),            // 0xAD
        Instruction({ xorToA(cpu.read(cpu.registers.hl)) }, 4), // 0xAE
        Instruction({ xorToA(cpu.registers.a) }, 4),            // 0xAF

        Instruction({ orToA(cpu.registers.b) }, 4),             // 0xB0
        Instruction({ orToA(cpu.registers.c) }, 4),             // 0xB1
        Instruction({ orToA(cpu.registers.d) }, 4),             // 0xB2
        Instruction({ orToA(cpu.registers.e) }, 4),             // 0xB3
        Instruction({ orToA(cpu.registers.h) }, 4),             // 0xB4
        Instruction({ orToA(cpu.registers.l) }, 4),             // 0xB5
        Instruction({ orToA(cpu.read(cpu.registers.hl)) }, 4),  // 0xB6
        Instruction({ orToA(cpu.registers.a) }, 4),             // 0xB7
        Instruction(::xxx, 0),   // 0xB8 todo
        Instruction(::xxx, 0),   // 0xB9 todo
        Instruction(::xxx, 0),   // 0xBA todo
        Instruction(::xxx, 0),   // 0xBB todo
        Instruction(::xxx, 0),   // 0xBC todo
        Instruction(::xxx, 0),   // 0xBD todo
        Instruction(::xxx, 0),   // 0xBE todo
        Instruction(::xxx, 0),   // 0xBF todo

        Instruction(::xxx, 0),   // 0xC0 todo
        Instruction(::xxx, 0),   // 0xC1 todo
        Instruction(::xxx, 0),   // 0xC2 todo
        Instruction(::xxx, 0),   // 0xC3 todo
        Instruction(::xxx, 0),   // 0xC4 todo
        Instruction(::xxx, 0),   // 0xC5 todo
        Instruction(::xxx, 0),   // 0xC6 todo
        Instruction(::xxx, 0),   // 0xC7 todo
        Instruction(::xxx, 0),   // 0xC8 todo
        Instruction(::xxx, 0),   // 0xC9 todo
        Instruction(::xxx, 0),   // 0xCA todo
        Instruction(::xxx, 0),   // 0xCB todo
        Instruction(::xxx, 0),   // 0xCC todo
        Instruction(::xxx, 0),   // 0xCD todo
        Instruction(::xxx, 0),   // 0xCE todo
        Instruction(::xxx, 0),   // 0xCF todo

        Instruction(::xxx, 0),   // 0xD0 todo
        Instruction(::xxx, 0),   // 0xD1 todo
        Instruction(::xxx, 0),   // 0xD2 todo
        Instruction(::xxx, 0),   // 0xD3 todo
        Instruction(::xxx, 0),   // 0xD4 todo
        Instruction(::xxx, 0),   // 0xD5 todo
        Instruction(::xxx, 0),   // 0xD6 todo
        Instruction(::xxx, 0),   // 0xD7 todo
        Instruction(::xxx, 0),   // 0xD8 todo
        Instruction(::xxx, 0),   // 0xD9 todo
        Instruction(::xxx, 0),   // 0xDA todo
        Instruction(::xxx, 0),   // 0xDB todo
        Instruction(::xxx, 0),   // 0xDC todo
        Instruction(::xxx, 0),   // 0xDD todo
        Instruction(::xxx, 0),   // 0xDE todo
        Instruction(::xxx, 0),   // 0xDF todo

        Instruction(::xxx, 0),   // 0xE0 todo
        Instruction(::xxx, 0),   // 0xE1 todo
        Instruction(::xxx, 0),   // 0xE2 todo
        Instruction(::xxx, 0),   // 0xE3 todo
        Instruction(::xxx, 0),   // 0xE4 todo
        Instruction(::xxx, 0),   // 0xE5 todo
        Instruction(::xxx, 0),   // 0xE6 todo
        Instruction(::xxx, 0),   // 0xE7 todo
        Instruction(::xxx, 0),   // 0xE8 todo
        Instruction(::xxx, 0),   // 0xE9 todo
        Instruction(::xxx, 0),   // 0xEA todo
        Instruction(::xxx, 0),   // 0xEB todo
        Instruction(::xxx, 0),   // 0xEC todo
        Instruction(::xxx, 0),   // 0xED todo
        Instruction(::xxx, 0),   // 0xEE todo
        Instruction(::xxx, 0),   // 0xEF todo

        Instruction(::xxx, 0),   // 0xF0 todo
        Instruction(::xxx, 0),   // 0xF1 todo
        Instruction(::xxx, 0),   // 0xF2 todo
        Instruction(::xxx, 0),   // 0xF3 todo
        Instruction(::xxx, 0),   // 0xF4 todo
        Instruction(::xxx, 0),   // 0xF5 todo
        Instruction(::xxx, 0),   // 0xF6 todo
        Instruction(::xxx, 0),   // 0xF7 todo
        Instruction(::xxx, 0),   // 0xF8 todo
        Instruction(::xxx, 0),   // 0xF9 todo
        Instruction(::xxx, 0),   // 0xFA todo
        Instruction(::xxx, 0),   // 0xFB todo
        Instruction(::xxx, 0),   // 0xFC todo
        Instruction(::xxx, 0),   // 0xFD todo
        Instruction(::xxx, 0),   // 0xFE todo
        Instruction(::xxx, 0)    // 0xFF todo
    )

    // Opcodes.
    private fun ldToB(data: UByte): Boolean {
        cpu.registers.b = data
        return false
    }

    private fun ldToC(data: UByte): Boolean {
        cpu.registers.c = data
        return false
    }

    private fun ldToD(data: UByte): Boolean {
        cpu.registers.d = data
        return false
    }

    private fun ldToE(data: UByte): Boolean {
        cpu.registers.e = data
        return false
    }

    private fun ldToH(data: UByte): Boolean {
        cpu.registers.h = data
        return false
    }

    private fun ldToL(data: UByte): Boolean {
        cpu.registers.l = data
        return false
    }

    private fun ldToAddr(addr: UShort, data: UByte): Boolean {
        cpu.write(addr, data)
        return false
    }

    private fun ldToA(data: UByte): Boolean {
        cpu.registers.a = data
        return false
    }

    private fun ldToBC(data: UShort): Boolean {
        cpu.registers.bc = data
        return false
    }

    private fun ldToDE(data: UShort): Boolean {
        cpu.registers.de = data
        return false
    }

    private fun ldToHL(data: UShort): Boolean {
        cpu.registers.hl = data
        return false
    }

    private fun ldToSP(data: UShort): Boolean {
        cpu.registers.sp = data
        return false
    }

    private fun addToA(data: UByte): Boolean {
        val result: UInt = cpu.registers.a + data
        val halfResult: UInt = (cpu.registers.a and 0xFu) + (data and 0xFu)

        cpu.registers.setZeroFlag(result == 0u)
        cpu.registers.setSubFlag(false)
        cpu.registers.setCarryFlag(result > 0xFFu)
        cpu.registers.setHalfCarryFlag(halfResult > 0xFu)

        cpu.registers.a = result.toUByte()

        return false
    }

    private fun adcToA(data: UByte): Boolean {
        val carryFlag: UInt = if (cpu.registers.getCarryFlag()) 1u else 0u
        val result: UInt = cpu.registers.a + data + carryFlag
        val halfResult: UInt = (cpu.registers.a and 0xFu) + (data and 0xFu) + carryFlag

        cpu.registers.setZeroFlag(result == 0u)
        cpu.registers.setSubFlag(false)
        cpu.registers.setCarryFlag(result > 0xFFu)
        cpu.registers.setHalfCarryFlag(halfResult > 0xFu)

        cpu.registers.a = result.toUByte()

        return false
    }

    private fun andToA(data: UByte): Boolean {
        val result: UByte = cpu.registers.a and data

        cpu.registers.setZeroFlag(result.toUInt() == 0u)
        cpu.registers.setSubFlag(false)
        cpu.registers.setCarryFlag(false)
        cpu.registers.setHalfCarryFlag(true)

        cpu.registers.a = result

        return false
    }

    private fun xorToA(data: UByte): Boolean {
        val result: UByte = cpu.registers.a xor data

        cpu.registers.setZeroFlag(result.toUInt() == 0u)
        cpu.registers.setSubFlag(false)
        cpu.registers.setCarryFlag(false)
        cpu.registers.setHalfCarryFlag(false)

        cpu.registers.a = result

        return false
    }

    private fun orToA(data: UByte): Boolean {
        val result: UByte = cpu.registers.a or data

        cpu.registers.setZeroFlag(result.toUInt() == 0u)
        cpu.registers.setSubFlag(false)
        cpu.registers.setCarryFlag(false)
        cpu.registers.setHalfCarryFlag(false)

        cpu.registers.a = result

        return false
    }

    private fun nop(): Boolean {
        return false;
    }

    private fun xxx(): Boolean {
        return false
    }

    // Helpers.
    fun readImmediate8(): UByte {
        val data: UByte = cpu.read(cpu.registers.pc)
        cpu.registers.pc++

        return data
    }

    fun readImmediate16(): UShort {
        // Little endian.
        val low = readImmediate8()
        val high = readImmediate8()

        return DataUtils.combine(high, low)
    }
}