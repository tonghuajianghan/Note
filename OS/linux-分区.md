---
title: linux 分区
date:
categories:
- linux
tags:
- linux分区/安装/命令/用户组
---


### 查看系统分区大小,查看文件夹大小

	df  可以查看一级文件夹大小、使用比例、档案系统及其挂入点，但对文件却无能为力。
			参数 -h 表示使用「Human-readable」的输出，也就是在档案系统大小使用 GB、MB 等易读的格式。
		
		[root@localhost ~]# df -h
		文件系统              容量  已用  可用 已用%% 挂载点
		/dev/sda3              16G   16G     0 100% /
		tmpfs                  16G     0   16G   0% /dev/shm
		/dev/sda1             194M   26M  159M  14% /boot
		/dev/mapper/vg0-lv1   5.8T  184M  5.5T   1% /data



	du  可以查看文件及文件夹的大小。

### fdisk 分区  
1. fdisk /dev/sdb  
2. fdisk命令参数介绍
	     p、打印分区表。
	     n、新建一个新分区。
	     d、删除一个分区。
	     m、输出菜单
	     q、退出不保存。
	     w、把分区写进分区表，保存并退出。
	 新增步骤:	(1)n (2)m (3)w

3. WARNING: Re-reading the partition table failed with error 16: 设备或资源忙. The kernel still uses the old 
  The kernel still uses the old table. The new table will be used at  
  the next reboot or after you run partprobe(8) or kpartx(8)
  Syncing disks.  
  - 为了不reboot就能生效，强制内核重新读取分区表
