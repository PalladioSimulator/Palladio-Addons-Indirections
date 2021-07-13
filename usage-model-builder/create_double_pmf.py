def create_double_pmf(distribution):
    return f'DoublePMF[{"".join((map(lambda it: f"({it[0]};{it[1]:.5f})", sorted(distribution.items()))))}]'
