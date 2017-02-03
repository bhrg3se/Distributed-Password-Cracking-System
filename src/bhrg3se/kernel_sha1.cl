// created on Dec 5, 2016

/**
 * @author Bhargab
 */
kernel void kernel_sha1(global float* a, const int size) {
    int id = get_global_id(0);
    if (id >= size) {
        return;
    }
    a[id] = 0;
}