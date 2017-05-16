# ADB-Project
Dataset provided by a Microsoft Research GeoLife GPS Trajectories, to cluster the given data set and provide enough data patterns to analyze the user patterns, hence clustering the significant locations. This location clustered data will then provide the enough knowledge about the user’s pattern.


1.	Analyzing the data for initial process of the data. Goal is to find the Points of interests:
	a.	As the projects main purpose is to cluster the given data set and provide enough data patterns to analyze the user patterns, hence clustering the significant locations. This location clustered data will then provide the enough knowledge about the user’s pattern, that we will be able to answers the query as discussed in the problem statement such as “where a particular user is most likely to be at a particular time of the day?”.   
	b.Let’s breakdown the given problem with respect to the short term goals,   
	i.	Finding places (significant points of interests.)  
	ii.	Cluster the locations using the “found places” is step i, using k-means algorithm. Before that we have to set distance Threshold.   
  
	Step I: Finding places (significant locations):  
	As we have seen the format of the data and how the data is collected: Location in latitude and longitude at every five seconds. These point in space, i.e. latitudes and longitudes are only recorded if the user is above at least 3.0 miles per hour. This means that when a user stops, that is when the user is below 3.0 miles per hour speed the data is stopped recording. This may hold true even if the user is taking a walk in Garden, or he is watching movie in a Theatre, or visiting a friend at his Dorm. Making the last point recorded the significant location, for example the while driving to the theatre the when the user parks his car, the last location recorded would be the location of the parking lot. (Provided he isn’t running!!).   
	As a result we can use this property of this dataset to determine the significant locations, using the time.  For instance the 	time between consecutive two records will determine whether the location is significant location.   
	Threshold Value for Time the amount of time which will determine that the location is significant will be the Threshold value, which is nothing but a time interval in minutes. Now, deciding this threshold value is very crucial to the project, if the threshold is less then minimum, we can miss more than few significant locations. On the other hand if the threshold value is more than the maximum we might add few locations which might not be very significant. These addition might feel like safer side, but can cause lot of calculation overheads. Hence this threshold value must be within these minimum and maximum limits, it must be optimal.         
	To evaluate this optimal threshold value we have to arrive with some test cases with certain assumptions about the users and places. Following describes the test cases considered for this project and the underlying assumptions.  


For following cases, 5 user’s data is used to test the threshold values:  
 	To make these test cases more reliable, the all the threshold values must be tested on user’s data. Out of these 5 users, 3 users are chosen at random (06, 12, 14), and one user with the lowest number of records (user-021) and another with highest number of records (user 41).  
  
Case 1: time gap >= 300 sec.    
	300 seconds almost evaluates to 5 minutes. The assumptions and the logic behind choosing this threshold value is to avoid counting in the stop signs, traffic lights and other obstacles which will make users stop for more than five seconds. In the graph, shown the number of users {06, 12, 14, 21, 41} in case 1   
    
Case 1: time gap >= 600 sec.    
	 In case 1, even users that have around 2000 records give more than 100 places for threshold value 300 sec. Now it doesn’t seem more but considering user-41’s data which yields almost 1200 places makes a difference. The idea here is to eliminate and refine data little bit more, eliminating locations such as Restrooms, Gas Stations, and Train stations.
	See figure-“User-41: case1” and   attached at the bottom of the report where the user is seem to travel long distance and has a lots of locations where time difference is more than 300 seconds.    

Fig-1:- Y-axis: No. of Places found, X-axis: Threshold cases.  


Test Case 3: time gap >= 300 && <=1800 sec.    
	Now, setting just lower bound isn’t enough, we have to eliminate the locations such as users’ home, office and other such places where users tend to stay for longer time but isn’t a significant public place or a place of interest.  


Test Case 4: time gap >= 600 && <=3600 sec.    
	For case 3 above the number of places considerably decreased, the numbers almost truncated to half. This extreme change is not good for optimizing the unknown parameter. Thus the time frame is increased to 60 minutes.      
  
And this test case-4 gives us the optimal solution on threshold time frame.  
  
{Folder “snapshots” contains plotted places of these 5 users}    
    
  
Step-II: Setting the optimal Threshold radius around the found locations.  
  
From the step-1 we found our optimal time frame to extract the number of places, mow the next step is to find an optimal threshold value for radial distance around the places found form step-1.  
Although for smaller distance the curve of the earth will not affect the result significantly, but to analysis more reliable, we must have to consider that parameter as a result to calculate the distance between two points the haversine formula is used where the Radius of earth is considered for calculating correct distances.  
  	
*Case-1: Radius = 3 miles – Case-4: Radius = 1.5:  This cases becomes hopeless as soon as the result of first location is observed which clusters	 around 10,000 points in one locations.  
 
*Case-5: Radius = 1.0 mile:  This makes appealing case but the radius is still large, collecting almost 5000 points in one cluster.  

#Final Case: Radius = 0.6 miles: Finally the results are in the range seem optimal, few locations have fewer than 100 records:  

### Here is the output of a Java program used for analyzing.  

User-012 having 105 No. of Clusters:  

1 -> for 39.983297, 116.30968 No. of clustered Records=279  
2 -> for 39.900747, 116.423935 No. of clustered Records=44  
3 -> for 39.902361, 116.422527 No. of clustered Records=78  
4 -> for 39.133291, 117.202803 No. of clustered Records=206  
5 -> for 39.11936, 117.239708 No. of clustered Records=7  
.  
.  
.  
89 -> for 39.987513, 116.317528 No. of clustered Records=14926  
90 -> for 39.987658, 116.317589 No. of clustered Records=14974  
91 -> for 39.989129, 116.31472 No. of clustered Records=13385  
92 -> for 39.989601, 116.31592 No. of clustered Records=14008  
93 -> for 39.988511, 116.317006 No. of clustered Records=14745  
94 -> for 39.988322, 116.317861 No. of clustered Records=15222  
95 -> for 39.988096, 116.317671 No. of clustered Records=15077  
96 -> for 39.984349, 116.322052 No. of clustered Records=3777  
97 -> for 39.987739, 116.317834 No. of clustered Records=15086  
98 -> for 39.987952, 116.316803 No. of clustered Records=14106  
99 -> for 39.988355, 116.317639 No. of clustered Records=15122  
100 -> for 39.988186, 116.31674 No. of clustered Records=14278  
101 -> for 39.988246, 116.317696 No. of clustered Records=15115  
102 -> for 39.989753, 116.316607 No. of clustered Records=14394  
103 -> for 39.988255, 116.317814 No. of clustered Records=15178  
104 -> for 39.988111, 116.318108 No. of clustered Records=15216  
105 -> for 39.987846, 116.317641 No. of clustered Records=15020  
   


References:  
 [1] Yu Zheng, Lizhu Zhang, Xing Xie, Wei-Ying Ma. Mining interesting locations and travel sequences from GPS trajectories. In Proceedings of International conference on World Wild Web (WWW 2009), Madrid Spain. ACM Press: 791-800.  
 [2] Yu Zheng, Quannan Li, Yukun Chen, Xing Xie, Wei-Ying Ma. Understanding Mobility Based on GPS Data. In Proceedings of ACM conference on Ubiquitous Computing (UbiComp 2008), Seoul, Korea. ACM Press: 312-321.   
[3] Yu Zheng, Xing Xie, Wei-Ying Ma, GeoLife: A Collaborative Social Networking Service among User, location and trajectory. Invited paper, in IEEE Data Engineering Bulletin. 33, 2, 2010, pp. 32-40.  
