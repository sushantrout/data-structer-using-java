package com.bip;

import java.util.*;
import java.time.*;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

class Data {
	private LocalDateTime st, et;
	long sd;
	DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");

	Data(String st, String et, long sd) throws Exception {
		this.st = LocalDateTime.parse(st, dt);
		this.et = LocalDateTime.parse(et, dt);
		this.sd = sd;
	}

	Data(LocalDateTime st, LocalDateTime et, long sd) {
		this.st = st;
		this.et = et;
		this.sd = sd;
	}

	public LocalDateTime getSt() {
		return st;
	}

	public LocalDateTime getEt() {
		return et;
	}

	public String toString() {
		return " " + getSt() + "   " + getEt() + "   " + sd;
	}

	public void setEt(LocalDateTime et) {
		this.et = et;
	}

	public void setSt(LocalDateTime st) {
		this.st = st;
	}

	public void setSd(LocalDateTime a, LocalDateTime b) {
		long t1 = Timestamp.valueOf(a).getTime();
		long t2 = Timestamp.valueOf(b).getTime();
		long sd = (t2 - t1) / (60 * 1000);
		this.sd = sd;
	}
}


public class Task1 {
	public static void printValues(ArrayList<Data> list) {
		for (int i = 0; i < list.size(); i++) {
			Data data = list.get(i);
			System.out.println(data.getSt() + "   " + data.getEt() + "   " + data.sd);
		}
	}

	public static ArrayList<Data> removeDuplicate(ArrayList<Data> list) {
		ArrayList<Data> newData = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Boolean isOccured = false;
			for (int j = 0; j < i; j++) {
				if (list.get(i).getSt().equals(list.get(j).getSt())
						&& list.get(i).getEt().equals(list.get(j).getEt())) {
					isOccured = true;
				}
			}
			if (!isOccured) {
				newData.add(list.get(i));
			}
		}
		return newData;
	}

	private static boolean isOverLapping(long aStart, long aEnd, long bStart, long bEnd) {
		if (aStart <= bStart && aEnd > bEnd)
			return true;
		if (aStart < bStart && aEnd >= bEnd)
			return true;
		return false;
	}

	public static void overLap(ArrayList<Data> arr) throws Exception {
		int size = arr.size() - 1;
		// case 1 : a is overlapping b
		for (int i = 0; i < size - 1; i++) {
			Data a = arr.get(i);
			long aStart = Timestamp.valueOf(a.getSt()).getTime();
			long aEnd = Timestamp.valueOf(a.getEt()).getTime();

			Data b = arr.get(i + 1);
			long bStart = Timestamp.valueOf(b.getSt()).getTime();
			long bEnd = Timestamp.valueOf(b.getEt()).getTime();

			while (isOverLapping(aStart, aEnd, bStart, bEnd)) {
				arr.remove(b);
				size--;
				if (i + 1 == size)
					break;
				b = arr.get(i + 1);

				bStart = Timestamp.valueOf(b.getSt()).getTime();
				bEnd = Timestamp.valueOf(b.getEt()).getTime();

			}

		}
		// case 2 : b is overlapping a
		for (int i = size; i > 0; i--) {
			Data a = arr.get(i);
			long aStart = Timestamp.valueOf(a.getSt()).getTime();
			long aEnd = Timestamp.valueOf(a.getEt()).getTime();

			Data b = arr.get(i - 1);
			long bStart = Timestamp.valueOf(b.getSt()).getTime();
			long bEnd = Timestamp.valueOf(b.getEt()).getTime();

			while (isOverLapping(aStart, aEnd, bStart, bEnd)) {
				arr.remove(b);
				size--;
				if (i - 1 >= 0)
					break;
				b = arr.get(i - 1);

				bStart = Timestamp.valueOf(b.getSt()).getTime();
				bEnd = Timestamp.valueOf(b.getEt()).getTime();

			}
		}
		// case 3 : partially overlapping
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				Data a = arr.get(i);
				long aStart = Timestamp.valueOf(a.getSt()).getTime();
				long aEnd = Timestamp.valueOf(a.getEt()).getTime();

				Data b = arr.get(j);
				long bStart = Timestamp.valueOf(b.getSt()).getTime();
				long bEnd = Timestamp.valueOf(b.getEt()).getTime();
				if (aStart <= bStart && aEnd <= bEnd && bStart <= aEnd) {
					a.setEt(b.getEt());
					arr.remove(j);
					j--;
					a.setSd(a.getSt(), b.getEt());

				}
			}
		}

	}

	public static void swap(ArrayList<Data> list, int i, int j) {
		Data temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public static void sort(ArrayList<Data> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getSt().isAfter(list.get(j).getSt())) {
					swap(list, i, j);
				} else if (list.get(i).getSt().equals(list.get(j).getSt())) {
					if (list.get(i).getEt().isAfter(list.get(j).getEt()))
						swap(list, i, j);
				}
			}
		}
	}

	public static void tSleepDuration(ArrayList<Data> list) {
		long tDuration = 0;
		for (int i = 0; i < list.size(); i++) {
			tDuration += list.get(i).sd;
		}
		System.out.println("Total sleep duration is: " + tDuration);
	}

	public static void main(String args[]) {
		try {
			ArrayList<Data> cData = new ArrayList<Data>();
			ArrayList<Data> mData = new ArrayList<>();
			int size;
			Scanner in = new Scanner(System.in);
			System.out.println("Enter size of records");
			size = in.nextInt();
			in.nextLine();
			for (int i = 0; i < size; i++) {

				System.out.println("Enter Start Date time:");
				String st = in.nextLine();
				System.out.println("Enter End Date time:");
				String et = in.nextLine();
				System.out.println("Enter sleep duration:");
				long sd = in.nextLong();
				in.nextLine();
				cData.add(new Data(st, et, sd));
			}
//		cData.add(new Data("20-Jan-23 23:00", "20-Jan-23 23:15", 15));
//		cData.add(new Data("20-Jan-23 23:00", "20-Jan-23 23:15", 15));
//		cData.add(new Data("20-Jan-23 23:00", "20-Jan-23 23:15", 15));
//		cData.add(new Data("20-Jan-23 23:20", "20-Jan-23 23:55", 35));
//		cData.add(new Data("20-Jan-23 23:20", "20-Jan-23 23:55", 35));
//		cData.add(new Data("20-Jan-23 23:55", "21-Jan-23 00:18", 23));
//		cData.add(new Data("21-Jan-23 00:20", "21-Jan-23 00:37", 17));
//		cData.add(new Data("21-Jan-23 00:20", "21-Jan-23 00:37", 17));
//		cData.add(new Data("21-Jan-23 00:38", "21-Jan-23 02:10", 92));
//		cData.add(new Data("21-Jan-23 00:38", "21-Jan-23 02:10", 92));
//		cData.add(new Data("21-Jan-23 00:38", "21-Jan-23 02:10", 92));
//		cData.add(new Data("21-Jan-23 00:38", "21-Jan-23 02:10", 92));
//		cData.add(new Data("21-Jan-23 02:10", "21-Jan-23 02:18", 8));
//		cData.add(new Data("21-Jan-23 02:22", "21-Jan-23 02:35", 13));
//		cData.add(new Data("21-Jan-23 02:36", "21-Jan-23 02:48", 12));
//		cData.add(new Data("21-Jan-23 02:36", "21-Jan-23 02:48", 12));
//		cData.add(new Data("21-Jan-23 02:48", "21-Jan-23 03:33", 45));
//		cData.add(new Data("21-Jan-23 02:48", "21-Jan-23 03:33", 45));
//		cData.add(new Data("21-Jan-23 02:20", "21-Jan-23 03:35", 75));
//		cData.add(new Data("21-Jan-23 02:20", "21-Jan-23 03:35", 75));
//		cData.add(new Data("21-Jan-23 03:36", "21-Jan-23 03:49", 13));
//		cData.add(new Data("21-Jan-23 03:49", "21-Jan-23 04:12", 23));
//		cData.add(new Data("21-Jan-23 03:49", "21-Jan-23 04:12", 23));
//		cData.add(new Data("21-Jan-23 04:12", "21-Jan-23 04:42", 30));
//		cData.add(new Data("21-Jan-23 04:12", "21-Jan-23 04:42", 30));
//		cData.add(new Data("21-Jan-23 04:43", "21-Jan-23 05:05", 22));
//		cData.add(new Data("21-Jan-23 03:49", "21-Jan-23 05:15", 86));
//		cData.add(new Data("21-Jan-23 03:49", "21-Jan-23 05:15", 86));
//		cData.add(new Data("21-Jan-23 03:49", "21-Jan-23 05:35", 106));
//		cData.add(new Data("21-Jan-23 05:36", "21-Jan-23 06:10", 34));
//		cData.add(new Data("21-Jan-23 05:36", "21-Jan-23 06:10", 34));
//		cData.add(new Data("21-Jan-23 06:10", "21-Jan-23 07:20", 70));
//		cData.add(new Data("21-Jan-23 07:05", "21-Jan-23 07:50", 45));
			mData = removeDuplicate(cData);
			sort(mData);
			// printValues(mData);
			overLap(mData);
			// System.out.println("========================");
			printValues(mData);
			tSleepDuration(mData);
		} catch (Exception e) {

		}
	}
}
