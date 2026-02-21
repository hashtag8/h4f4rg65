package com.bfrx;

import defpackage.mk;
import defpackage.ml;
import defpackage.mm;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Device implements Serializable {
    private byte CHANNEL_TYPE_ALONE;
    public String deviceInfo;
    public int deviceIp;
    public byte[] groupName;
    public int groupNumber;
    public boolean isPartyMode;
    public boolean isPlaying;
    public boolean isSource;
    public String key;
    public byte[] label;
    public int nError;
    public int newGroupNumber;
    public int ownerId;
    public int priority;
    public int protocol;
    private int role;
    public int softwareStatus;
    public String ssid;
    public String testVolume;
    public long uniqueID;
    public boolean updateAvailable;
    private byte[] version;
    public int volumeLevel;

    public int getRole() {
        return this.role;
    }

    public void setRole(int i) {
        mm.b();
        mm.b((Object) (this + "setRole role = " + i));
        this.role = i;
    }

    public Device() {
        this.uniqueID = 0L;
        this.protocol = 0;
        this.role = 21;
        this.groupNumber = 0;
        this.ssid = "";
        this.key = "off";
        this.deviceInfo = "";
        this.newGroupNumber = 0;
        this.updateAvailable = false;
        this.isPartyMode = false;
        this.isPlaying = false;
        this.isSource = false;
        this.nError = 0;
        this.deviceIp = 0;
        this.volumeLevel = 0;
        this.priority = 0;
        this.ownerId = 0;
        this.softwareStatus = 0;
        this.CHANNEL_TYPE_ALONE = (byte) 0;
        this.label = new byte[32];
        this.groupName = new byte[32];
    }

    public Device(Device device) {
        this.uniqueID = 0L;
        this.protocol = 0;
        this.role = 21;
        this.groupNumber = 0;
        this.ssid = "";
        this.key = "off";
        this.deviceInfo = "";
        this.newGroupNumber = 0;
        this.updateAvailable = false;
        this.isPartyMode = false;
        this.isPlaying = false;
        this.isSource = false;
        this.nError = 0;
        this.deviceIp = 0;
        this.volumeLevel = 0;
        this.priority = 0;
        this.ownerId = 0;
        this.softwareStatus = 0;
        this.CHANNEL_TYPE_ALONE = (byte) 0;
        this.uniqueID = device.uniqueID;
        this.protocol = device.protocol;
        this.role = device.role;
        this.label = Arrays.copyOf(device.label, device.label.length);
        this.groupNumber = 0;
        this.groupName = Arrays.copyOf(device.groupName, device.groupName.length);
        this.ssid = device.ssid;
        this.key = device.key;
        this.deviceInfo = device.deviceInfo;
        this.newGroupNumber = device.newGroupNumber;
        this.updateAvailable = device.updateAvailable;
        this.isPartyMode = device.isPartyMode;
        this.nError = device.nError;
        this.deviceIp = device.deviceIp;
        this.volumeLevel = device.volumeLevel;
        this.priority = device.priority;
        this.ownerId = device.ownerId;
        this.softwareStatus = device.softwareStatus;
        this.testVolume = device.testVolume;
    }

    public boolean isSame(Device device) {
        return device.role == this.role && Arrays.equals(device.label, this.label) && device.groupNumber == this.groupNumber && Arrays.equals(device.groupName, this.groupName) && device.deviceIp == this.deviceIp && device.volumeLevel == this.volumeLevel;
    }

    public synchronized Device marshall() {
        Device device;
        device = new Device(this);
        zeroToFF(device.label);
        zeroToFF(device.groupName);
        device.label[device.label.length - 1] = 0;
        device.groupName[device.groupName.length - 1] = 0;
        return device;
    }

    private void zeroToFF(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                bArr[i] = -1;
            }
        }
    }

    public synchronized Device unmarshall() {
        Device device;
        device = new Device(this);
        ffToZero(device.label);
        ffToZero(device.groupName);
        return device;
    }

    private void ffToZero(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == -1) {
                bArr[i] = 0;
            }
        }
    }

    private static byte[] removeZeroFF(byte[] bArr) {
        int i = 0;
        while (i < bArr.length && bArr[i] != 0 && bArr[i] != -1) {
            i++;
        }
        return Arrays.copyOf(bArr, i);
    }

    public synchronized String getMkGroupName() {
        return parseGroupName(this.label);
    }

    public static String parseGroupName(byte[] bArr) {
        byte[] bArr2 = new byte[25];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return new String(removeZeroFF(bArr2));
    }

    public synchronized void setMkGroupName(String str) {
        byte[] bytes = str.getBytes();
        if (bytes.length > 24) {
            new ml().a("name length longer than 24");
        }
        int iMin = Math.min(bytes.length, 24);
        System.arraycopy(bytes, 0, this.label, 0, iMin);
        this.label[iMin] = 0;
    }

    public synchronized byte[] getMkVersion() {
        return this.version != null ? this.version : Arrays.copyOfRange(this.label, 25, 29);
    }

    public synchronized byte[] getMkVersionOfPrivateC() {
        return this.version;
    }

    public synchronized void setMkVersion(byte[] bArr) {
        this.version = bArr;
    }

    public synchronized int getMkColorIndex() {
        return this.label[29];
    }

    public synchronized void setMkColorIndex(int i) {
        this.label[29] = (byte) i;
    }

    public synchronized byte getMkType() {
        byte b;
        b = this.label[30];
        if (b == 0 || b == -1) {
            b = 1;
        }
        return b;
    }

    public synchronized void setMkType(byte b) {
        this.label[30] = b;
    }

    public synchronized byte[] getMkReserve() {
        return Arrays.copyOf(this.groupName, 5);
    }

    public synchronized int getMkGroupId() {
        return parseGroupId(this.groupName);
    }

    public static int parseGroupId(byte[] bArr) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, 5, bArr2, 0, bArr2.length);
        return mk.d(bArr2);
    }

    public synchronized void setMkGroupId(int i) {
        byte[] bArrC = mk.c(i);
        System.arraycopy(bArrC, 0, this.groupName, 5, bArrC.length);
    }

    public synchronized int getMkRoomId() {
        return parseRoomId(this.groupName);
    }

    public static int parseRoomId(byte[] bArr) {
        return mk.d(Arrays.copyOfRange(bArr, 7, 9));
    }

    public synchronized void setMkRoomId(int i) {
        byte[] bArrC = mk.c(i);
        System.arraycopy(bArrC, 0, this.groupName, 7, bArrC.length);
    }

    public synchronized byte getMkMaster() {
        return this.groupName[9];
    }

    public synchronized void setMkMaster(int i) {
        this.groupName[9] = (byte) i;
    }

    public synchronized byte getMkChannelType() {
        byte b;
        b = this.groupName[10];
        if (b <= 0) {
            b = this.CHANNEL_TYPE_ALONE;
        }
        return b;
    }

    public synchronized void setMkChannelType(byte b) {
        this.groupName[10] = b;
    }

    public synchronized byte getMkParentControl() {
        return this.groupName[11];
    }

    public synchronized void setMkParentControl(byte b) {
        this.groupName[11] = b;
    }

    public synchronized int getMkIconIndex() {
        return this.groupName[12];
    }

    public synchronized void setMkIconIndex(int i) {
        this.groupName[12] = (byte) i;
    }

    public synchronized String getMkRoomName() {
        byte[] bArr;
        bArr = new byte[19];
        System.arraycopy(this.groupName, 13, bArr, 0, bArr.length);
        return new String(removeZeroFF(bArr));
    }

    public synchronized void setMkRoomName(String str) {
        byte[] bytes = str.getBytes();
        if (bytes.length > 18) {
            new ml().a("name length longer than 18");
        }
        int iMin = Math.min(bytes.length, 18);
        System.arraycopy(bytes, 0, this.groupName, 13, iMin);
        this.groupName[iMin + 13] = 0;
    }

    public synchronized byte[] copyLabel() {
        return Arrays.copyOf(this.label, this.label.length);
    }

    public synchronized byte[] copyGroupName() {
        return Arrays.copyOf(this.groupName, this.groupName.length);
    }

    public String toString() {
        String str = "hashCode() = " + hashCode() + " , getMkType() = " + ((int) getMkType()) + ": role = " + this.role + " , uniqueID = " + this.uniqueID;
        if (this.nError > 0) {
            return str + "[Err:" + this.nError + "]";
        }
        return str;
    }
}
