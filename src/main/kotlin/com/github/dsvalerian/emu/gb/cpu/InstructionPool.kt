package com.github.dsvalerian.emu.gb.cpu

class InstructionPool(private val cpu: Cpu) {
    val lookup: Array<Instruction> = arrayOf(
        Instruction(::xxx, 0, 0),   // 0x00 todo
        Instruction(::xxx, 0, 0),   // 0x01 todo
        Instruction(::xxx, 0, 0),   // 0x02 todo
        Instruction(::xxx, 0, 0),   // 0x03 todo
        Instruction(::xxx, 0, 0),   // 0x04 todo
        Instruction(::xxx, 0, 0),   // 0x05 todo
        Instruction(::xxx, 0, 0),   // 0x06 todo
        Instruction(::xxx, 0, 0),   // 0x07 todo
        Instruction(::xxx, 0, 0),   // 0x08 todo
        Instruction(::xxx, 0, 0),   // 0x09 todo
        Instruction(::xxx, 0, 0),   // 0x0A todo
        Instruction(::xxx, 0, 0),   // 0x0B todo
        Instruction(::xxx, 0, 0),   // 0x0C todo
        Instruction(::xxx, 0, 0),   // 0x0D todo
        Instruction(::xxx, 0, 0),   // 0x0E todo
        Instruction(::xxx, 0, 0),   // 0x0F todo

        Instruction(::xxx, 0, 0),   // 0x10 todo
        Instruction(::xxx, 0, 0),   // 0x11 todo
        Instruction(::xxx, 0, 0),   // 0x12 todo
        Instruction(::xxx, 0, 0),   // 0x13 todo
        Instruction(::xxx, 0, 0),   // 0x14 todo
        Instruction(::xxx, 0, 0),   // 0x15 todo
        Instruction(::xxx, 0, 0),   // 0x16 todo
        Instruction(::xxx, 0, 0),   // 0x17 todo
        Instruction(::xxx, 0, 0),   // 0x18 todo
        Instruction(::xxx, 0, 0),   // 0x19 todo
        Instruction(::xxx, 0, 0),   // 0x1A todo
        Instruction(::xxx, 0, 0),   // 0x1B todo
        Instruction(::xxx, 0, 0),   // 0x1C todo
        Instruction(::xxx, 0, 0),   // 0x1D todo
        Instruction(::xxx, 0, 0),   // 0x1E todo
        Instruction(::xxx, 0, 0),   // 0x1F todo

        Instruction(::xxx, 0, 0),   // 0x20 todo
        Instruction(::xxx, 0, 0),   // 0x21 todo
        Instruction(::xxx, 0, 0),   // 0x22 todo
        Instruction(::xxx, 0, 0),   // 0x23 todo
        Instruction(::xxx, 0, 0),   // 0x24 todo
        Instruction(::xxx, 0, 0),   // 0x25 todo
        Instruction(::xxx, 0, 0),   // 0x26 todo
        Instruction(::xxx, 0, 0),   // 0x27 todo
        Instruction(::xxx, 0, 0),   // 0x28 todo
        Instruction(::xxx, 0, 0),   // 0x29 todo
        Instruction(::xxx, 0, 0),   // 0x2A todo
        Instruction(::xxx, 0, 0),   // 0x2B todo
        Instruction(::xxx, 0, 0),   // 0x2C todo
        Instruction(::xxx, 0, 0),   // 0x2D todo
        Instruction(::xxx, 0, 0),   // 0x2E todo
        Instruction(::xxx, 0, 0),   // 0x2F todo

        Instruction(::xxx, 0, 0),   // 0x30 todo
        Instruction(::xxx, 0, 0),   // 0x31 todo
        Instruction(::xxx, 0, 0),   // 0x32 todo
        Instruction(::xxx, 0, 0),   // 0x33 todo
        Instruction(::xxx, 0, 0),   // 0x34 todo
        Instruction(::xxx, 0, 0),   // 0x35 todo
        Instruction(::xxx, 0, 0),   // 0x36 todo
        Instruction(::xxx, 0, 0),   // 0x37 todo
        Instruction(::xxx, 0, 0),   // 0x38 todo
        Instruction(::xxx, 0, 0),   // 0x39 todo
        Instruction(::xxx, 0, 0),   // 0x3A todo
        Instruction(::xxx, 0, 0),   // 0x3B todo
        Instruction(::xxx, 0, 0),   // 0x3C todo
        Instruction(::xxx, 0, 0),   // 0x3D todo
        Instruction(::xxx, 0, 0),   // 0x3E todo
        Instruction(::xxx, 0, 0),   // 0x3F todo

        Instruction({ ldToB(cpu.registers.b) }, 4, 0),              // 0x40
        Instruction({ ldToB(cpu.registers.c) }, 4, 0),              // 0x41
        Instruction({ ldToB(cpu.registers.d) }, 4, 0),              // 0x42
        Instruction({ ldToB(cpu.registers.e) }, 4, 0),              // 0x43
        Instruction({ ldToB(cpu.registers.h) }, 4, 0),              // 0x44
        Instruction({ ldToB(cpu.registers.l) }, 4, 0),              // 0x45
        Instruction({ ldToB(cpu.read(cpu.registers.hl)) }, 8, 0),   // 0x46
        Instruction({ ldToB(cpu.registers.b) }, 4, 0),              // 0x47
        Instruction({ ldToC(cpu.registers.b) }, 4, 0),              // 0x48
        Instruction({ ldToC(cpu.registers.c) }, 4, 0),              // 0x49
        Instruction({ ldToC(cpu.registers.d) }, 4, 0),              // 0x4A
        Instruction({ ldToC(cpu.registers.e) }, 4, 0),              // 0x4B
        Instruction({ ldToC(cpu.registers.h) }, 4, 0),              // 0x4C
        Instruction({ ldToC(cpu.registers.l) }, 4, 0),              // 0x4D
        Instruction({ ldToC(cpu.read(cpu.registers.hl)) }, 8, 0),   // 0x4E
        Instruction({ ldToC(cpu.registers.b) }, 4, 0),              // 0x4F

        Instruction({ ldToD(cpu.registers.b) }, 4, 0),              // 0x50
        Instruction({ ldToD(cpu.registers.c) }, 4, 0),              // 0x51
        Instruction({ ldToD(cpu.registers.d) }, 4, 0),              // 0x52
        Instruction({ ldToD(cpu.registers.e) }, 4, 0),              // 0x53
        Instruction({ ldToD(cpu.registers.h) }, 4, 0),              // 0x54
        Instruction({ ldToD(cpu.registers.l) }, 4, 0),              // 0x55
        Instruction({ ldToD(cpu.read(cpu.registers.hl)) }, 8, 0),   // 0x56
        Instruction({ ldToD(cpu.registers.b) }, 4, 0),              // 0x57
        Instruction({ ldToE(cpu.registers.b) }, 4, 0),              // 0x58
        Instruction({ ldToE(cpu.registers.c) }, 4, 0),              // 0x59
        Instruction({ ldToE(cpu.registers.d) }, 4, 0),              // 0x5A
        Instruction({ ldToE(cpu.registers.e) }, 4, 0),              // 0x5B
        Instruction({ ldToE(cpu.registers.h) }, 4, 0),              // 0x5C
        Instruction({ ldToE(cpu.registers.l) }, 4, 0),              // 0x5D
        Instruction({ ldToE(cpu.read(cpu.registers.hl)) }, 8, 0),   // 0x5E
        Instruction({ ldToE(cpu.registers.b) }, 4, 0),              // 0x5F

        Instruction({ ldToH(cpu.registers.b) }, 4, 0),              // 0x60
        Instruction({ ldToH(cpu.registers.c) }, 4, 0),              // 0x61
        Instruction({ ldToH(cpu.registers.d) }, 4, 0),              // 0x62
        Instruction({ ldToH(cpu.registers.e) }, 4, 0),              // 0x63
        Instruction({ ldToH(cpu.registers.h) }, 4, 0),              // 0x64
        Instruction({ ldToH(cpu.registers.l) }, 4, 0),              // 0x65
        Instruction({ ldToH(cpu.read(cpu.registers.hl)) }, 8, 0),   // 0x66
        Instruction({ ldToH(cpu.registers.b) }, 4, 0),              // 0x67
        Instruction({ ldToL(cpu.registers.b) }, 4, 0),              // 0x68
        Instruction({ ldToL(cpu.registers.c) }, 4, 0),              // 0x69
        Instruction({ ldToL(cpu.registers.d) }, 4, 0),              // 0x6A
        Instruction({ ldToL(cpu.registers.e) }, 4, 0),              // 0x6B
        Instruction({ ldToL(cpu.registers.h) }, 4, 0),              // 0x6C
        Instruction({ ldToL(cpu.registers.l) }, 4, 0),              // 0x6D
        Instruction({ ldToL(cpu.read(cpu.registers.hl)) }, 8, 0),   // 0x6E
        Instruction({ ldToL(cpu.registers.b) }, 4, 0),              // 0x6F

        Instruction({ ldToHLAddr(cpu.registers.b) }, 4, 0),         // 0x70
        Instruction({ ldToHLAddr(cpu.registers.c) }, 4, 0),         // 0x71
        Instruction({ ldToHLAddr(cpu.registers.d) }, 4, 0),         // 0x72
        Instruction({ ldToHLAddr(cpu.registers.e) }, 4, 0),         // 0x73
        Instruction({ ldToHLAddr(cpu.registers.h) }, 4, 0),         // 0x74
        Instruction({ ldToHLAddr(cpu.registers.l) }, 4, 0),         // 0x75
        Instruction(::xxx, 0, 0),                                   // 0x76 todo
        Instruction({ ldToHLAddr(cpu.registers.b) }, 4, 0),         // 0x77
        Instruction({ ldToA(cpu.registers.b) }, 4, 0),              // 0x78
        Instruction({ ldToA(cpu.registers.c) }, 4, 0),              // 0x79
        Instruction({ ldToA(cpu.registers.d) }, 4, 0),              // 0x7A
        Instruction({ ldToA(cpu.registers.e) }, 4, 0),              // 0x7B
        Instruction({ ldToA(cpu.registers.h) }, 4, 0),              // 0x7C
        Instruction({ ldToA(cpu.registers.l) }, 4, 0),              // 0x7D
        Instruction({ ldToA(cpu.read(cpu.registers.hl)) }, 8, 0),   // 0x7E
        Instruction({ ldToA(cpu.registers.b) }, 4, 0),              // 0x7F

        Instruction(::xxx, 0, 0),   // 0x80 todo
        Instruction(::xxx, 0, 0),   // 0x81 todo
        Instruction(::xxx, 0, 0),   // 0x82 todo
        Instruction(::xxx, 0, 0),   // 0x83 todo
        Instruction(::xxx, 0, 0),   // 0x84 todo
        Instruction(::xxx, 0, 0),   // 0x85 todo
        Instruction(::xxx, 0, 0),   // 0x86 todo
        Instruction(::xxx, 0, 0),   // 0x87 todo
        Instruction(::xxx, 0, 0),   // 0x88 todo
        Instruction(::xxx, 0, 0),   // 0x89 todo
        Instruction(::xxx, 0, 0),   // 0x8A todo
        Instruction(::xxx, 0, 0),   // 0x8B todo
        Instruction(::xxx, 0, 0),   // 0x8C todo
        Instruction(::xxx, 0, 0),   // 0x8D todo
        Instruction(::xxx, 0, 0),   // 0x8E todo
        Instruction(::xxx, 0, 0),   // 0x8F todo

        Instruction(::xxx, 0, 0),   // 0x90 todo
        Instruction(::xxx, 0, 0),   // 0x91 todo
        Instruction(::xxx, 0, 0),   // 0x92 todo
        Instruction(::xxx, 0, 0),   // 0x93 todo
        Instruction(::xxx, 0, 0),   // 0x94 todo
        Instruction(::xxx, 0, 0),   // 0x95 todo
        Instruction(::xxx, 0, 0),   // 0x96 todo
        Instruction(::xxx, 0, 0),   // 0x97 todo
        Instruction(::xxx, 0, 0),   // 0x98 todo
        Instruction(::xxx, 0, 0),   // 0x99 todo
        Instruction(::xxx, 0, 0),   // 0x9A todo
        Instruction(::xxx, 0, 0),   // 0x9B todo
        Instruction(::xxx, 0, 0),   // 0x9C todo
        Instruction(::xxx, 0, 0),   // 0x9D todo
        Instruction(::xxx, 0, 0),   // 0x9E todo
        Instruction(::xxx, 0, 0),   // 0x9F todo

        Instruction(::xxx, 0, 0),   // 0xA0 todo
        Instruction(::xxx, 0, 0),   // 0xA1 todo
        Instruction(::xxx, 0, 0),   // 0xA2 todo
        Instruction(::xxx, 0, 0),   // 0xA3 todo
        Instruction(::xxx, 0, 0),   // 0xA4 todo
        Instruction(::xxx, 0, 0),   // 0xA5 todo
        Instruction(::xxx, 0, 0),   // 0xA6 todo
        Instruction(::xxx, 0, 0),   // 0xA7 todo
        Instruction(::xxx, 0, 0),   // 0xA8 todo
        Instruction(::xxx, 0, 0),   // 0xA9 todo
        Instruction(::xxx, 0, 0),   // 0xAA todo
        Instruction(::xxx, 0, 0),   // 0xAB todo
        Instruction(::xxx, 0, 0),   // 0xAC todo
        Instruction(::xxx, 0, 0),   // 0xAD todo
        Instruction(::xxx, 0, 0),   // 0xAE todo
        Instruction(::xxx, 0, 0),   // 0xAF todo

        Instruction(::xxx, 0, 0),   // 0xB0 todo
        Instruction(::xxx, 0, 0),   // 0xB1 todo
        Instruction(::xxx, 0, 0),   // 0xB2 todo
        Instruction(::xxx, 0, 0),   // 0xB3 todo
        Instruction(::xxx, 0, 0),   // 0xB4 todo
        Instruction(::xxx, 0, 0),   // 0xB5 todo
        Instruction(::xxx, 0, 0),   // 0xB6 todo
        Instruction(::xxx, 0, 0),   // 0xB7 todo
        Instruction(::xxx, 0, 0),   // 0xB8 todo
        Instruction(::xxx, 0, 0),   // 0xB9 todo
        Instruction(::xxx, 0, 0),   // 0xBA todo
        Instruction(::xxx, 0, 0),   // 0xBB todo
        Instruction(::xxx, 0, 0),   // 0xBC todo
        Instruction(::xxx, 0, 0),   // 0xBD todo
        Instruction(::xxx, 0, 0),   // 0xBE todo
        Instruction(::xxx, 0, 0),   // 0xBF todo

        Instruction(::xxx, 0, 0),   // 0xC0 todo
        Instruction(::xxx, 0, 0),   // 0xC1 todo
        Instruction(::xxx, 0, 0),   // 0xC2 todo
        Instruction(::xxx, 0, 0),   // 0xC3 todo
        Instruction(::xxx, 0, 0),   // 0xC4 todo
        Instruction(::xxx, 0, 0),   // 0xC5 todo
        Instruction(::xxx, 0, 0),   // 0xC6 todo
        Instruction(::xxx, 0, 0),   // 0xC7 todo
        Instruction(::xxx, 0, 0),   // 0xC8 todo
        Instruction(::xxx, 0, 0),   // 0xC9 todo
        Instruction(::xxx, 0, 0),   // 0xCA todo
        Instruction(::xxx, 0, 0),   // 0xCB todo
        Instruction(::xxx, 0, 0),   // 0xCC todo
        Instruction(::xxx, 0, 0),   // 0xCD todo
        Instruction(::xxx, 0, 0),   // 0xCE todo
        Instruction(::xxx, 0, 0),   // 0xCF todo

        Instruction(::xxx, 0, 0),   // 0xD0 todo
        Instruction(::xxx, 0, 0),   // 0xD1 todo
        Instruction(::xxx, 0, 0),   // 0xD2 todo
        Instruction(::xxx, 0, 0),   // 0xD3 todo
        Instruction(::xxx, 0, 0),   // 0xD4 todo
        Instruction(::xxx, 0, 0),   // 0xD5 todo
        Instruction(::xxx, 0, 0),   // 0xD6 todo
        Instruction(::xxx, 0, 0),   // 0xD7 todo
        Instruction(::xxx, 0, 0),   // 0xD8 todo
        Instruction(::xxx, 0, 0),   // 0xD9 todo
        Instruction(::xxx, 0, 0),   // 0xDA todo
        Instruction(::xxx, 0, 0),   // 0xDB todo
        Instruction(::xxx, 0, 0),   // 0xDC todo
        Instruction(::xxx, 0, 0),   // 0xDD todo
        Instruction(::xxx, 0, 0),   // 0xDE todo
        Instruction(::xxx, 0, 0),   // 0xDF todo

        Instruction(::xxx, 0, 0),   // 0xE0 todo
        Instruction(::xxx, 0, 0),   // 0xE1 todo
        Instruction(::xxx, 0, 0),   // 0xE2 todo
        Instruction(::xxx, 0, 0),   // 0xE3 todo
        Instruction(::xxx, 0, 0),   // 0xE4 todo
        Instruction(::xxx, 0, 0),   // 0xE5 todo
        Instruction(::xxx, 0, 0),   // 0xE6 todo
        Instruction(::xxx, 0, 0),   // 0xE7 todo
        Instruction(::xxx, 0, 0),   // 0xE8 todo
        Instruction(::xxx, 0, 0),   // 0xE9 todo
        Instruction(::xxx, 0, 0),   // 0xEA todo
        Instruction(::xxx, 0, 0),   // 0xEB todo
        Instruction(::xxx, 0, 0),   // 0xEC todo
        Instruction(::xxx, 0, 0),   // 0xED todo
        Instruction(::xxx, 0, 0),   // 0xEE todo
        Instruction(::xxx, 0, 0),   // 0xEF todo

        Instruction(::xxx, 0, 0),   // 0xF0 todo
        Instruction(::xxx, 0, 0),   // 0xF1 todo
        Instruction(::xxx, 0, 0),   // 0xF2 todo
        Instruction(::xxx, 0, 0),   // 0xF3 todo
        Instruction(::xxx, 0, 0),   // 0xF4 todo
        Instruction(::xxx, 0, 0),   // 0xF5 todo
        Instruction(::xxx, 0, 0),   // 0xF6 todo
        Instruction(::xxx, 0, 0),   // 0xF7 todo
        Instruction(::xxx, 0, 0),   // 0xF8 todo
        Instruction(::xxx, 0, 0),   // 0xF9 todo
        Instruction(::xxx, 0, 0),   // 0xFA todo
        Instruction(::xxx, 0, 0),   // 0xFB todo
        Instruction(::xxx, 0, 0),   // 0xFC todo
        Instruction(::xxx, 0, 0),   // 0xFD todo
        Instruction(::xxx, 0, 0),   // 0xFE todo
        Instruction(::xxx, 0, 0)    // 0xFF todo
    )

    // Opcodes.
    private fun ldToB(data: UByte): Boolean {
        cpu.registers.b = data
        return false;
    }

    private fun ldToC(data: UByte): Boolean {
        cpu.registers.c = data
        return false;
    }

    private fun ldToD(data: UByte): Boolean {
        cpu.registers.d = data
        return false;
    }

    private fun ldToE(data: UByte): Boolean {
        cpu.registers.e = data
        return false;
    }

    private fun ldToH(data: UByte): Boolean {
        cpu.registers.h = data
        return false;
    }

    private fun ldToL(data: UByte): Boolean {
        cpu.registers.l = data
        return false;
    }

    private fun ldToHLAddr(data: UByte): Boolean {
        cpu.write(cpu.registers.hl, data)
        return false
    }

    private fun ldToA(data: UByte): Boolean {
        cpu.registers.a = data
        return false;
    }

    private fun xxx(): Boolean {
        return false
    }
}