- - # The Case for Apache Hadoop
    ## Chapter 2
    <a name="The_Case_for_Apache_Hadoop"/>

    ---

    # Course Chapter

    - [Introduction](#Introduction)
    - **[The Case for Apache Hadoop](#The_Case_for_Apache_Hadoop)**
    - [Hadoop Cluster Installation](#Hadoop_Cluster_Installation)
    - [The Hadoop Distributed File System (HDFS)](#The_Hadoop_Distributed_File_System)
    - [MapReduce and Spark on YARN](#MapReduce_and_Spark_on_YARN)
    - [Hadoop Configuration and Daemon Logs](#Hadoop_Configuration_and_Daemon_Logs)
    - [Getting Data Into HDFS](#Getting_Data_Into_HDFS)
    - [Planning Your Hadoop Cluster](#Planning_Your_Hadoop_Cluster)
    - [Installing and Configuring Hive, Impala, and Pig](#Installing_and_Configuring_Hive_Impala_and_Pig)
    - [Hadoop Clients Including Hue](#Hadoop_Clients_Including_Hue)
    - [Advanced Cluster Configuration](#Advanced_Cluster_Configuration)
    - [Hadoop Security](#Hadoop_Security)
    - [Managing Resources](#Managing_Resources)
    - [Cluster Maintenance](#Cluster_Maintenance)
    - [Cluster Monitoring and Troubleshooting](#Cluster_Monitoring_and_Troubleshooting)
    - [Conclusion](#Conclusion)

    ---

    # The Case for Apache Hadoop

    In this chapter, you will learn:

    - Why Hadoop is needed
    - What problems Hadoop solves
    - What comprises Hadoop and the Hadoop ecosystem

    ---

    # Chapter Topics

    The Case for Apache Hadoop

    - **Why Hadoop?**
    - Fundamental Concepts
    - Core Hadoop Components
    - Conclusion
    - Hands-On Exercise: Network Setup

    ---

    # The Data Deluge (1)

    - We are generating more data than ever
      - Financial transactions
      - Sensor networks
      - Server logs
      - Analytics
      - e-mail and text messages
      - Social media

    ---

    # The Data Deluge (2)

    - And we are generating data faster than ever
      - Automation
      - Ubiquitous internet connectivity
      - User-generated content
    - For example, every day
      - Twitter processes 500 million messages
      - Amazon S3 storage adds more than one billion objects
      - Facebook users generate 4.5 billion comments and "Likes"

    ---

    # Data is Value

    - This data has many valuable applications
      - Marketing analysis
      - Product recommendations
      - Demand forecasting
      - Fraud detection
      - And many, many more...
    - We must process it to extract that value

    ---

    # Data Processing Scalability

    - How can we process all that information?
    - There are actually two problems
      - Large-scale data storage
      - Large-scale data analysis

    ---

    # Disk Capacity and Price

    - We are generating more data than ever before
    - Fortunately, the size and cost of storage has kept pace
      - Capacity has increased while price has decreased
        ![inline 100%](./images/disk_capacity_and_price.png)

    ---

    # Disk Capacity and Performance

    - Disk performance has also increased in the last 15 years
    - Unfortunately, transfer rates have not kept pace with capacity
      ![inline 100%](./images/disk_capacity_and_performance.png)

    ---

    # Data Access is the Bottleneck

    - Although we can process data more quickly, accessing it is slow
      - This is true for both reads and writes
    - For example, reading a single 3TB disk takes almost four hours
      - We cannot process the data until we have read it
      - We are limited by the speed of a single disk
    - We will see Hadoop's solution in a few moments
      - But first we will examine how we process large amounts of data

    ---

    # Monolithic Computing

    - Traditionally, computation has been processor-bound
      - Intense processing on small amounts of data
    - For decades, the goal was a bigger, more powerful machine
      - Faster processor, more RAM
    - This approach has limitations
      - High cost
      - Limited scalability
        ![inline 100%](https://s-media-cache-ak0.pinimg.com/236x/e7/da/bc/e7dabc5e1c8d98d1565fac8469b1b4ab.jpg)

    ---

    ## The Case for Distributed Systems

    > In pioneer days they used oxen for heavy pulling, and when one ox couldn’t budge a log, they didn’t try to grow a larger ox. We shouldn’t be trying for bigger computers, but for more systems of computers.
    > -- Grace Hopper

    ![right 150%](https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Grace_Hopper.jpg/220px-Grace_Hopper.jpg)

    ---

    # Distributed Computing

    - Modern large-scale processing is distributed across machines
      - Often hundreds or thousands of nodes
      - Common frameworks include MPI, PVM and Condor
    - Focuses on distributing the processing workload
      - Powerful compute nodes
      - Separate systems for data storage
      - Fast network connections to connect them

    ---

    ## Distributed Computing Processing Pattern

    - Typical processing pattern
      - Step 1: Copy input data from storage to compute node
      - Step 2: Perform necessary processing
      - Step 3: Copy output data back to storage
    - This works fine with relatively small amounts of data
      - That is, where step 2 dominates overall runtime
        ![inline 100%](./images/distributed_computing_processing_pattern.png)

    ---

    # Data Processing Bottleneck

    - That pattern does not scale with large amounts of data
      - More time spent copying data than actually processing it
      - Getting data to the processors is the bottleneck
    - Grows worse as more compute nodes are added
      - They are competing for the same bandwidth
      - Compute nodes become starved for data

    ---

    ## Complexity of Distributed Computing

    - Distributed systems pay for scalability by adding complexity
    - Much of this complexity involves
      - Availability
      - Data consistency
      - Event synchronization
      - Bandwidth limitations
      - Partial failure
      - Cascading failures
    - These are often more difficult than the original problem
      - Error handling often accounts for the majority of the code

    ---

    ## System Requirements: Failure Handling

    - Failure is inevitable
      - We should strive to handle it well
    - An ideal solution should have (at least) these properties
      ![inline 100%](./images/system_requirements_failure_handling.png)

    ---

    # More System Requirements

    - Linear horizontal scalability
      - Adding new nodes should add proportional load capacity
      - Avoid contention by using a "shared nothing" architecture
      - Must be able to expand cluster at a reasonable cost
    - Jobs run in relative isolation
      - Results must be independent of other jobs running concurrently
      - Although performance can be affected by other jobs
    - Simple programming model
      - Should support a widely-used language
      - The API must be relatively easy to learn
    - Hadoop addresses these requirements

    ---

    # Chapter Topics

    The Case for Apache Hadoop

    - Why Hadoop?
    - **Fundamental Concepts**
    - Core Hadoop Components
    - Conclusion
    - Hands-On Exercise: Network Setup

    ---

    # Hadoop: A Radical Solution

    - Traditional distributed computing frequently involves
      - Complex programming requiring explicit synchronization
      - Expensive, specialized fault-tolerant hardware
      - High-performance storage system
    - Hadoop takes a radically different approach
      - Inspired by Google's GFS and MapReduce architecture
      - This new approach addresses the problems described earlier

    ---

    # Hadoop Scalability

    - Hadoop aims for linear horizontal scalability
      - Cross-communication among nodes is minimal
      - Just add nodes to increase cluster capacity and performance
    - Clusters are built from industry-standard hardware
      - Widely-available and relatively inexpensive servers
      - You can "scale out" later when the need arises

    ---

    # Solution: Data Access Bottleneck

    - Recap: separate storage and compute systems create bottleneck
      - Can spend more time copying data than processing it
    - Solution: store and process data on the same machines
      - This is why adding nodes increases capacity and performance
    - Optimization: Use intelligent job scheduling (data locality)
      - Hadoop tries to process data on the same machine that stores it
      - This improves performance and conserves bandwidth
      - "Bring the computation to the data"

    ---

    ## Solution: Disk Performance Bottleneck

    - Recap: a single disk has great capacity but poor performance
    - Solution: use multiple disks in parallel
      - The transfer rate of one disk might be 210 megabytes/second
      - Almost four hours to read 3 TB of data
      - 1000 such disks in parallel can transfer 210 gigabytes/second
      - Less than 15 seconds to read 3TB of data
    - Colocated storage and processing makes this solution feasible
      - 100-node cluster with 10 disks per node = 1000 disks

    ---

    # Solution: Complex Processing Code

    - Recap: Distributed programming is very difficult
      - Often done in C or FORTRAN using complex libraries
    - Solution: Use a popular language and a high-level API
      - MapReduce code is typically written in Java (like Hadoop itself)
        - It is possible to write MapReduce in nearly any language
    - The MapReduce programming model simplifies processing
      - Deal with one record (key-value pair) at a time
      - Complex details are abstracted away
        - No file I/O
        - No networking code
        - No synchronization

    ---

    # Solution: Fault Tolerance

    - Recap: Distributed systems often use expensive components
      - In order to minimize the _possibility_ of failure
    - Solution: Realize that failure is inevitable
      - And instead try to minimize the _effect_ of failure
      - Hadoop satisfies all the requirements we discussed earlier
    - Machine failure is a regular occurrence
      - A server might have a mean time between failures (MTBF) of 5 years (~1825 days)
      - Equates about one failure per day in a 2,000 node cluster

    ---

    # Chapter Topics

    The Case for Apache Hadoop

    - Why Hadoop?
    - Fundamental Concepts
    - **Core Hadoop Components**
    - Conclusion
    - Hands-On Exercise: Network Setup

    ---

    # Core Hadoop Components

    - Hadoop is a system for large-scale data processing
    - Hadoop provides
      - HDFS for data storage
      - The extensible YARN framework
        - For application scheduling and resource management
        - Includes MapReduce version 2 for data processing
    - Plus the infrastructure needed to make them work, including
      - Filesystem utilities
      - Application scheduling and monitoring
      - Web UI

    ---

    # The Hadoop Ecosystem

    - Many related tools integrate with Hadoop
      - Data processing: Spark
      - Data analysis: Hive, Pig, and Impala
      - Data discovery: Solr (Cloudera Search)
      - Machine learning: MLlib, Mahout, and others
      - Data ingestion: Sqoop, Flume, Kafka
      - Coordination: ZooKeeper
      - User experience: Hue
      - Workflow management: Oozie
      - Cluster management: Cloudera Manager
    - These are not considered "core Hadoop"
      - Rather, they are part of the "Hadoop ecosystem"
      - Many are also open source Apache projects
      - We will learn about several of these later in the course

    ---

    # Chapter Topics

    The Case for Apache Hadoop

    - Why Hadoop?
    - Fundamental Concepts
    - Core Hadoop Components
    - **Conclusion**
    - Hands-On Exercise: Network Setup

    ---

    # Essential Points

    - We are generating more data
      - and faster
      - than ever before
    - We can store and process the data, but there are problems using existing techniques
      - Accessing the data from disk is a bottleneck
      - In distributed systems, getting data to the processors is a bottleneck
    - Hadoop eliminates the bottlenecks by storing and processing data on the same machine

    ---

    # Chapter Topics

    The Case for Apache Hadoop

    - Why Hadoop?
    - Fundamental Concepts
    - Core Hadoop Components
    - Conclusion
    - **Hands-On Exercise: Network Setup**

    ---

    ## Hands-On Exercise: Configuring Networking

    - In this Hands-On Exercise, you will configure network connectivity for your environment: _local_ or _cloud_
    - Please refer to the Hands-On Exercise Manual

    > Note: Each machine in the exercises is assigned an animal name for convenience

    ![right fit](./images/hands-on_exercise_configuring_networking.png)

    ---

---