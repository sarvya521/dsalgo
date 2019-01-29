import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhotoManager {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static class Photo {
		private Integer id;
		private String number;
		private String name;
		private String extension;
		private String city;
		private Date time;

		public Photo(Integer id, String name, String city, Date time) {
			this.id = id;
			this.name = name;
			this.city = city;
			this.time = time;
			this.extension = name.split("\\.")[1];
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getExtension() {
			return extension;
		}

		public void setExtension(String extension) {
			this.extension = extension;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Photo other = (Photo) obj;
			if (id != other.id)
				return false;
			return true;
		}

		/*@Override
		public String toString() {
			return "Photo [id=" + id + ", number=" + number + ", name=" + name + ", city="
					+ city + ", time=" + time + "]";
		}*/

		@Override
		public String toString() {
			return city+number+"."+extension;
		}
		
	}

	static Date getDate(String s) {
		Date date = null;
		try {
			date = DATE_FORMAT.parse(s);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}
	
	static String getPhotoNumber(int n, int leadingZero) {
		return String.format("%0"+leadingZero+"d", n);
	}

	public static String solution(String S) {
		List<Photo> photos = new ArrayList<Photo>();
		Map<String, List<Photo>> map = new HashMap<String, List<Photo>>();
		int id = 1;
		Scanner scanner = new Scanner(S);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] arr = line.split(",");
			Photo photo = new Photo(id++, arr[0].trim(), arr[1].trim(), getDate(arr[2].trim()));
			photos.add(photo);
		}
		scanner.close();
		
		for(Photo photo: photos) {
			String city = photo.getCity();
			if(map.containsKey(city)) {
				map.get(city).add(photo);
			} else {
				List<Photo> list = new ArrayList<Photo>();
				list.add(photo);
				map.put(city, list);
			}
		}
		
		photos.clear();
		
		for(List<Photo> cityPhotos : map.values()) {
			Collections.sort(cityPhotos, new Comparator<Photo>() {
				@Override
				public int compare(Photo p1, Photo p2) {
					return p1.getTime().compareTo(p2.getTime());
				}
			});
			int size = cityPhotos.size();
			int leadingZero = String.valueOf(size).length();
			for(int i = 0; i < size; i++) {
				Photo photo = cityPhotos.get(i);
				photo.setNumber(getPhotoNumber(i+1, leadingZero));
			}
			photos.addAll(cityPhotos);
		}
		
		Collections.sort(photos, new Comparator<Photo>() {
			@Override
			public int compare(Photo p1, Photo p2) {
				return p1.getId().compareTo(p2.getId());
			}
		});
		
		StringBuilder builder = new StringBuilder();
		for(Photo photo: photos) {
			builder.append(photo.toString()).append("\n");
		}
		return builder.toString().trim();
	}

	public static void main(String[] args) {
		String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11";
		System.out.println(solution(S));
	}

}
