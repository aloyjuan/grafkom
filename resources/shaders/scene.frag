#version 330
out vec4 frag_color;
// in -> mendapat data dari luar frag
// out -> mengeluarkan data dari frag
// tidak bisa pakai code ini di frag --> layout (location=0) in vec3 position;
void main() {
    frag_color = vec4(1.0, 0.0, 0.0, 1.0);
}