pub fn build_proverb(list: &[&str]) -> String {
    let mut the_prov: String = String::new();
    if !list.is_empty() {
        for i in 1..list.len() {
            the_prov += &format!("For want of a {} the {} was lost.\n", list[i - 1], list[i]);
        }
        the_prov += &format!("And all for the want of a {}.", list[0]);
    }
    the_prov
}
