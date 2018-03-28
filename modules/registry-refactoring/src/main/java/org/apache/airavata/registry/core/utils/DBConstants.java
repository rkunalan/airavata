package org.apache.airavata.registry.core.utils;

public class DBConstants {

    public static int SELECT_MAX_ROWS = 1000;
    public static final String CONFIGURATION = "Configuration";

    public static class ComputeResourcePreference {
        public static final String GATEWAY_ID = "gatewayId";
    }

    public static class StorageResourcePreference {
        public static final String GATEWAY_ID = "gatewayId";
    }

    public static class ComputeResource {
        public static final String HOST_NAME = "hostName";
        public static final String COMPUTE_RESOURCE_ID = "computeResourceId";
    }

    public static class ResourceJobManager {
        public static final String RESOURCE_JOB_MANAGER_ID = "resourceJobManagerId";
    }

    public static class GroupResourceProfile {
        public static final String GATEWAY_ID = "gatewayId";
        public static final String GROUP_RESOURCE_PROFILE_ID = "groupResourceProfileId";
    }

    public static class UserResourceProfile {
        public static final String USER_ID = "userId";
        public static final String GATEWAY_ID = "gatewayId";
    }

    public static class UserComputeResourcePreference {
        public static final String USER_ID = "userId";
        public static final String GATEWAY_ID = "gatewayId";
        public static final String COMPUTE_RESOURCE_ID = "computeResourceId";
    }

    public static class UserStoragePreference {
        public static final String USER_ID = "userId";
        public static final String GATEWAY_ID = "gatewayId";
        public static final String STORAGE_RESOURCE_ID = "storageResourceId";
    }

    public static class DataProduct {
        public static final String GATEWAY_ID = "gatewayId";
        public static final String OWNER_NAME = "ownerName";
        public static final String PRODUCT_NAME = "productName";
        public static final String PARENT_PRODUCT_URI = "parentProductUri";
    }

}
